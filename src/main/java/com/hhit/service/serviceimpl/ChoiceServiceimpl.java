package com.hhit.service.serviceimpl;

import com.hhit.dao.ChoiceDao;
import com.hhit.model.choicequestion;
import com.hhit.service.ChoiceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="choiceservice")
public class ChoiceServiceimpl implements ChoiceService {
    @Resource
    ChoiceDao choiceDao;

    @Override
    public List<choicequestion> selectchoice() {
        return choiceDao.selectchoice();
    }

}


