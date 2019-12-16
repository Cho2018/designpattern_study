package ch20.hw;

import java.util.HashMap;

//BigChar의 인스턴스를 공유하면서 생성하는 클래스
public class BigCharFactory {
    private HashMap pool = new HashMap(); //이미 만들어진 BigChar의 인스턴스를 관리
    private static BigCharFactory singleton = new BigCharFactory(); //Singleton 패턴

    //생성자
    private BigCharFactory() {
    }

    //유일한 인스턴스를 얻는다.
    public static BigCharFactory getInstance() {
        return singleton;
    }

    //BigChar의 인스턴스 생성(공유)
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar)pool.get("" + charname);

        //이미 만들어진 문자가 아니라면
        if (bc == null) {
            bc = new BigChar(charname); //여기에서 BigChar의 인스턴스를 생성
            pool.put("" + charname, bc);
        }

        return bc;
    }
}
