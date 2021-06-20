package com.github.ilyavidineev.jrtb.service;

import com.github.ilyavidineev.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.ilyavidineev.jrtb.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
