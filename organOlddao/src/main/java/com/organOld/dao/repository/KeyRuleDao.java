package com.organOld.dao.repository;

import com.organOld.dao.entity.oldman.KeyRule;

import java.util.List;

public interface KeyRuleDao {
    List<KeyRule> getAll();

    List<KeyRule> getAllRule();

    void updateByIds(List<KeyRule> keyRuleList);
}
