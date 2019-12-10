package ch19.hw;

//주간의 상태를 나타내는 클래스
public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() { //생성자는 private
    }

    public static State getInstance() { //유일한 인스턴스를 얻는다.
        return singleton;
    } //유일한 인스턴스를 얻는다.

    public void doClock(Context context, int hour) { //시간설정
        if (hour < 9 || (17 <= hour && hour < 20)) { //시스템의 상태를 야간으로 바꾼다.
            context.changeState(NightState.getInstance());
        } else if (12 <= hour && hour < 13) { //시스템의 상태를 점심시간으로 바꾼다.
            context.changeState(NoonState.getInstance());
        } else if (20 <= hour && hour <= 24) { //시스템의 상태를 야식시간으로 바꾼다.(20 ~ 24)
            context.changeState(NightMealState.getInstance());
        }
    }

    public void doUse(Context context) { //금고사용
        context.recordLog("금고사용(주간)");
    }

    public void doAlarm(Context context) { //비상벨
        context.callSecurityCenter("비상벨(주간)");
    }

    public void doPhone(Context context) { //일반통화
        context.callSecurityCenter("일반통화(주간)");
    }

    @Override
    public void doCCTV(Context context) { //CCTV
        context.recordLog("CCTV: 해상도 600 dpi로 변경");
    }

    public String toString() { //문자열 표현
        return "[주간]";
    }
}
