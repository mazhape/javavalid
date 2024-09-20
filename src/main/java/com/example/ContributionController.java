package com.example;

import com.example.domain.Contribution;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Controller;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller("/contribution")
public class ContributionController{
    protected final ContributionRepository contributionRepository;

    public ContributionController( ContributionRepository contributionRepository){
        this.contributionRepository = contributionRepository;
    }

    @Get("/{id}")
    public Optional<Contribution> show(Long id){
        return contributionRepository.findById(id);
    }

    @Post
    public HttpResponse<Contribution> index(@Body @Valid ContributionSaveCommand Command){
        Contribution contribution = new Contribution();
        contribution.setHwai_id(Command.getHwai_id());
        contribution.setAmount(Command.getAmount());

        Contribution savedContribution = contributionRepository.save(contribution);
        return HttpResponse.created(savedContribution).headers(headers->
                headers.location(location(contribution.getId())));
    }
    @Put
    public HttpResponse update(@Body @Valid ContributionUpdateCommand command){
        contributionRepository.update(command.getId(), command.getHwai_id(), command.getCenter(),command.getAmount());
        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(command.getId()).getPath());
    }

    @Get
    public List<Contribution> chero( Pageable pageable){
        return contributionRepository.findAll(pageable).getContent();
    }
    protected URI location(Long id){
        return URI.create("/contribution/" + id);
    }
    protected URI location(Contribution contribution){
        return location(contribution.getId());
    }
}