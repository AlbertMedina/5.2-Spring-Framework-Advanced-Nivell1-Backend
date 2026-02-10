package com.videostore.videostore.infrastructure.persistence.specification.movie;

import com.videostore.videostore.domain.model.movie.MovieSortBy;
import com.videostore.videostore.infrastructure.persistence.entity.MovieEntity;
import com.videostore.videostore.infrastructure.persistence.entity.RentalEntity;
import com.videostore.videostore.infrastructure.persistence.entity.ReviewEntity;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class MovieSpecifications {

    public static Specification<MovieEntity> genreEquals(String genre) {
        return (root, query, cb) ->
                genre == null || genre.isBlank() ? null : cb.equal(cb.lower(root.get("genre")), genre.toLowerCase());
    }

    public static Specification<MovieEntity> titleContains(String title) {
        return (root, query, cb) ->
                title == null || title.isBlank() ? null : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<MovieEntity> onlyAvailable(boolean onlyAvailable) {
        return (root, query, cb) -> {
            if (!onlyAvailable) {
                return null;
            }

            Objects.requireNonNull(query);

            Subquery<Long> subquery = query.subquery(Long.class);
            Root<RentalEntity> rentalRoot = subquery.from(RentalEntity.class);

            subquery.select(cb.count(rentalRoot))
                    .where(
                            cb.equal(rentalRoot.get("movie"), root)
                    );

            return cb.greaterThan(
                    root.get("numberOfCopies"),
                    subquery
            );
        };
    }

    public static Specification<MovieEntity> applySorting(
            MovieSortBy sortBy,
            boolean ascending
    ) {
        if (sortBy == null) {
            sortBy = MovieSortBy.TITLE;
        }

        return switch (sortBy) {
            case TITLE -> orderByTitle(ascending);
            case RATING -> orderByRating(ascending);
        };
    }


    public static Specification<MovieEntity> orderByTitle(boolean ascending) {
        return (root, query, cb) -> {
            if (ascending) {
                query.orderBy(cb.asc(root.get("title")));
            } else {
                query.orderBy(cb.desc(root.get("title")));
            }
            return cb.conjunction();
        };
    }

    public static Specification<MovieEntity> orderByRating(boolean ascending) {
        return (root, query, cb) -> {
            Objects.requireNonNull(query);

            Subquery<Double> avgSubquery = query.subquery(Double.class);
            Root<ReviewEntity> reviewRootAvg = avgSubquery.from(ReviewEntity.class);

            Expression<Double> avgExpr = cb.avg(reviewRootAvg.get("rating"));

            avgSubquery
                    .select(avgExpr)
                    .where(cb.equal(reviewRootAvg.get("movie"), root));

            Subquery<Long> countSubquery = query.subquery(Long.class);
            Root<ReviewEntity> reviewRootCount = countSubquery.from(ReviewEntity.class);

            Expression<Long> countExpr = cb.count(reviewRootCount);

            countSubquery
                    .select(countExpr)
                    .where(cb.equal(reviewRootCount.get("movie"), root));

            Order hasRatingsFirst = cb.desc(countSubquery);

            Order ratingOrder = ascending
                    ? cb.asc(avgSubquery)
                    : cb.desc(avgSubquery);

            query.orderBy(hasRatingsFirst, ratingOrder);

            return cb.conjunction();
        };
    }
}
