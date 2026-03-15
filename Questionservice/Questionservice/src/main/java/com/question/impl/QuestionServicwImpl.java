package com.question.impl;

import com.question.entity.Question;
import com.question.repository.QuestionRepository;
import com.question.service.QuestionService;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionServicwImpl implements QuestionService {

    private QuestionRepository questionRepository;

    public QuestionServicwImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question create(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
    }
}
