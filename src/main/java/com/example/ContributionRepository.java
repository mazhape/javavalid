package com.example;

import com.example.domain.Contribution;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;
import jakarta.validation.constraints.NotNull;


@JdbcRepository(dialect = Dialect.MYSQL)
public interface ContributionRepository extends PageableRepository<Contribution, Long> {

        Contribution save(@NotNull Long hwai_id, @NotNull Long center, @NotNull Float amount);

        long update(@NotNull @Id Long id, @NotNull Long hwai_id, @NotNull Long center ,@NotNull Float amount);

        long delete(@NotNull @Id Long id);
    }
