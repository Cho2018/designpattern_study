package ch20.hw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//큰 문자를 나타내는 클래스
public class BigChar {
    private char charname; //문자의 이름
    private String fontdata; //큰 문자를 표현하는 문자열('#' '.' '\n'의 열)

    //생성자
    public BigChar(char charname) {
        this.charname = charname;

        try {
            //해당 파일이 있으면
            //한줄씩 읽어 StringBuffer에 계속해서 덧붙이고
            //그것을 String 타입으로 변환에 fontdata에 담는다.
            BufferedReader reader = new BufferedReader(
                    new FileReader("big" + charname + ".txt")
            );

            String line;
            StringBuffer buf = new StringBuffer();

            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }

            reader.close();

            this.fontdata = buf.toString();
        } catch (IOException e) {
            //해당 파일이 없으면
            //다음과 같이 fontdata를 구성한다.
            this.fontdata = charname + "?";
        }
    }

    //큰 문자를 표현한다.
    public String print() {
        return fontdata;
    }
}
