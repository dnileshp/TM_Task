package hello.controller;

import hello.dto.ResponseDTO;
import hello.interfaces.WordInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class WordController {

    @Resource(name = "wordService")
    private WordInterface wordInterface;

    @GetMapping(value = "/words/{word}")
    public @ResponseBody
    ResponseDTO processWords(@PathVariable String word) {

        return wordInterface.findWordType(word);
    }
}
