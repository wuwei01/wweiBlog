package io.github.wuwei01.service.impl;

import io.github.wuwei01.entity.NbaPlayer;
import io.github.wuwei01.mapper.NbaPlayerMapper;
import io.github.wuwei01.service.NbaPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName：NbaPlayerServiceImpl
 * @Description：TODO
 * @Author：wuwei
 * @Date：2020/8/17 11:57 上午
 * @Versiion：1.0
 */
@Service
public class NbaPlayerServiceImpl implements NbaPlayerService {
    @Autowired
    private NbaPlayerMapper nbaPlayerMapper;
    @Override
    public List<NbaPlayer> ListNbaPlayer() {
        return nbaPlayerMapper.ListNbaPlayer();
    }
}
