package hello.interfaces;

import hello.dto.ResponseDTO;

public interface WordInterface {

    ResponseDTO findWordType(String word);
}
