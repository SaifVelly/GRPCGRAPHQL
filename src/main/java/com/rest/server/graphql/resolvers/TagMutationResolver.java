package com.rest.server.graphql.resolvers;

import com.rest.server.graphql.inputs.TagInput;
import com.rest.server.models.Tag;
import com.rest.server.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TagMutationResolver {

    @Autowired
    private TagService tagService;

    @MutationMapping
    public Tag createTag(@Argument TagInput input) {
        Tag tag = new Tag();
        tag.setTagName(input.getTagName());
        return tagService.createTag(tag);
    }

    @MutationMapping
    public Tag updateTag(@Argument String id, @Argument TagInput input) {
        Tag updated = new Tag();
        updated.setTagName(input.getTagName());
        return tagService.updateTag(id, updated);
    }

    @MutationMapping
    public String deleteTag(@Argument String id) {
        tagService.deleteTag(id);
        return id;
    }
}
