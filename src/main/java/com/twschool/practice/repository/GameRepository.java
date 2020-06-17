package com.twschool.practice.repository;

import com.twschool.practice.domain.UserGameInfo;

import java.util.HashMap;
import java.util.Map;

public class GameRepository {
    private Map<String, UserGameInfo> userGameInfoRepository = new HashMap<String, UserGameInfo>(32);

    public UserGameInfo getUserGameInfoById(String id) {
        return userGameInfoRepository.get(id);
    }

    public UserGameInfo updateUserGameInfoById(String id, UserGameInfo userGameInfo) {
        if (!id.equals(userGameInfo.getUserId())) {
            return null;
        }
        return userGameInfoRepository.put(id, userGameInfo);
    }

    public UserGameInfo registerUserGameInfo(UserGameInfo userGameInfo) {
        return userGameInfoRepository.put(userGameInfo.getUserId(), userGameInfo);
    }
}
