package com.rest.server.graphql.resolvers;

import com.rest.server.graphql.inputs.TagPage;
import com.rest.server.models.Tag;
import com.rest.server.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TagQueryResolver {

    @Autowired
    private TagService tagService;

    @QueryMapping
    public TagPage getAllTags(@Argument int page, @Argument int size) {
        Page<Tag> tagsPage = tagService.allTags(PageRequest.of(page, size));
        return new TagPage(tagsPage.getContent(), tagsPage.getTotalElements(), page, size);
    }

    @QueryMapping
    public Tag getSingleTag(@Argument String id) {
        return tagService.singleTag(id).orElse(null);
    }
}
