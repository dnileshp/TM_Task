package hello.services;

import hello.dto.ResponseDTO;
import hello.interfaces.WordInterface;
import org.springframework.stereotype.Service;

@Service(value = "wordService")
public class WordService implements WordInterface {


    private static boolean findPalindrome(String word) {

        String reverse = new StringBuffer(word).reverse().toString();
        return word.equals(reverse);
    }

    private static boolean checkPalindrome(String input) {
        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            count[ch - 'a']++;
        }
        int oddOccur = 0;
        for (int cnt : count) {
            if (oddOccur > 1) // more than 1 char should have odd frequency
                return false;
            if (cnt % 2 == 1)
                oddOccur++;
        }
        return true;
    }

    @Override
    public ResponseDTO findWordType(String word) {

        ResponseDTO responseDTO = new ResponseDTO();
        try {

            boolean IsPalindrome;
            boolean IsAnagramOfPalindrome;

            IsPalindrome = findPalindrome(word);
            IsAnagramOfPalindrome = checkPalindrome(word);

            responseDTO.setAnagramOfPalindrome(IsAnagramOfPalindrome);
            responseDTO.setPalindrome(IsPalindrome);
            responseDTO.setWord(word);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseDTO;
    }


}
