package ch20.hw;

//BigChar를 모아서 만든 큰 문자열을 나타내는 클래스
public class BigString {
    //큰 문자의 배열
    private BigChar[] bigchars;

    //생성자
    public BigString(String string) {
        initShared(string);
    }

    //생성자
    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initUnshared(string);
        }
    }

    //공유해서 초기화
    //Flyweight 패턴 적용
    //이미 만들어진 문자에 대해서는 다시 만들지 않음
    private void initShared(String string) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();

        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    //공유하지 않고 초기화
    //Flyweight 패턴 적용하지 않음
    //같은 문자라도 객체를 또 만듦
    private void initUnshared(String string) {
        bigchars = new BigChar[string.length()];

        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    //표시
    //'123'의 경우 1, 2, 3 모두 표현하기 위해
    //String 타입의 변수를 하나 두고 거기에 덧붙인 다음
    //그것을 반환한다.(TextArea에 출력하기 위해)
    public String print() {
        String string = "";

        for (int i = 0; i < bigchars.length; i++) {
            string += bigchars[i].print();
        }

        return string;
    }
}
