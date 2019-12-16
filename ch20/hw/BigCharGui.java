package ch20.hw;

import java.awt.*;
import java.awt.event.*;

public class BigCharGui extends Frame implements ActionListener {
    private TextField textString = new TextField(30); //문자열 입력 칸
    private TextField textSharedMemory = new TextField(20); //Flyweight 패턴 적용한 메모리 사용량 표시 칸
    private TextField textUnsharedMemory = new TextField(20); //Flyweight 패턴 적용하지 않은 메모리 사용량 표시 칸
    private TextArea textSharedScreen = new TextArea("", 10, 25, TextArea.SCROLLBARS_BOTH); //Flyweight 패턴 적용한 문자열의 큰 문자 출력 칸
    private TextArea textUnsharedScreen = new TextArea("", 10, 25, TextArea.SCROLLBARS_BOTH); //Flyweight 패턴 적용하지 않은 문자열의 큰 문자 출력 칸
    private Button buttonShared = new Button("공유해서 큰 문자 생성"); //'공유해서 큰 문자 생성' 버튼
    private Button buttonUnshared = new Button("공유하지 않은 큰 문자 생성"); //'공유하지 않은 큰 문자 생성' 버튼

    private static BigString[] bsarray = new BigString[1000]; //큰 문자열의 배열

    //생성자
    public BigCharGui(String title) {
        super(title);

        setBackground(Color.lightGray); //배경색 설정
        setLayout(new BorderLayout(10, 10)); //레이아웃 설정(간격 줌)
        setSize(550, 350); //크기 설정

        showNorth(); //북쪽에 배치하는 메소드
        showWest(); //서쪽에 배치하는 메소드
        showEast(); //동쪽에 배치하는 메소드

        //TextArea 폰트 지정(모든 문자에 같은 폭 가지도록)
        textSharedScreen.setFont(new Font("monospaced",Font.BOLD,13));
        textUnsharedScreen.setFont(new Font("monospaced",Font.BOLD,13));

        //임의로 변경 못하게 설정
        textSharedMemory.setEditable(false);
        textUnsharedMemory.setEditable(false);
        textSharedScreen.setEditable(false);
        textUnsharedScreen.setEditable(false);

        //표시
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }); //X 버튼 눌렀을 때 종료

        //listener의 설정
        buttonShared.addActionListener(this);
        buttonUnshared.addActionListener(this);
    }

    //문자열 입력 칸 북쪽에 배치하는 메소드
    void showNorth() {
        Panel panel = new Panel();
        panel.add(textString);
        add(panel, BorderLayout.NORTH);
    }

    //'공유해서 큰 문자 생성'과 관련된 버튼, 텍스트 필드, 텍스트 에리아 서쪽에 배치하는 메소드
    void showWest() {
        Panel panel2 = new Panel(new BorderLayout(10, 10));
        panel2.add(buttonShared, BorderLayout.NORTH);
        panel2.add(textSharedMemory, BorderLayout.CENTER);
        panel2.add(textSharedScreen, BorderLayout.SOUTH);
        add(panel2, BorderLayout.WEST);
    }

    //'공유하지 않은 큰 문자 생성'과 관련된 버튼, 텍스트 필드, 텍스트 에리아 동쪽에 배치하는 메소드
    void showEast() {
        Panel panel3 = new Panel(new BorderLayout(10, 10));
        panel3.add(buttonUnshared, BorderLayout.NORTH);
        panel3.add(textUnsharedMemory, BorderLayout.CENTER);
        panel3.add(textUnsharedScreen, BorderLayout.SOUTH);
        add(panel3, BorderLayout.EAST);
    }

    //버튼이 눌러졌을 때
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("" + e);

        if (e.getSource() == buttonShared) { //'공유해서 큰 문자 생성' 버튼
            testAllocation(true);
        } else if (e.getSource() == buttonUnshared) { //'공유하지 않은 큰 문자 생성' 버튼
            testAllocation(false);
        } else {
            System.out.println("?");
        }
    }

    //버튼 종류에 따라 shared 값이 달라지고
    //shared 값은
    //Flyweight 패턴 적용 여부를 표현함
    public void testAllocation(boolean shared) {
        for (int i = 0; i < bsarray.length; i++) {
            bsarray[i] = new BigString(textString.getText(), shared);
        }

        showMemory(shared);
        showPrint(shared);
    }

    //메모리 사용량 계산해서 버튼 밑에 있는 텍스트 필드에 보여주는 메소드
    public void showMemory(boolean shared) {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        if (shared == true) {
            textSharedMemory.setText("메모리 사용량: " + used);
        } else {
            textUnsharedMemory.setText("메모리 사용량: " + used);
        }
    }

    //문자열의 큰 문자를 텍스트 에리아에 출력하는 메소드
    public void showPrint(boolean shared) {
        if (shared == true) {
            textSharedScreen.setText(bsarray[0].print());
        } else {
            textUnsharedScreen.setText(bsarray[0].print());
        }
    }
}
