package ch19.hw;

//야식시간의 상태를 나타내는 클래스
public class NightMealState implements State {
    private static NightMealState singleton = new NightMealState();

    private NightMealState() { //생성자는 private
    }

    public static State getInstance() { //유일한 인스턴스를 얻는다.
        return singleton;
    } //유일한 인스턴스를 얻는다.

    public void doClock(Context context, int hour) { //시간설정
        if (hour < 9 || (17 <= hour && hour < 20)) { //시스템의 상태를 야간으로 바꾼다.
            context.changeState(NightState.getInstance());
        } else if (12 <= hour && hour < 13) { //시스템의 상태를 점심시간으로 바꾼다.
            context.changeState(NoonState.getInstance());
        } else if ((9 <= hour && hour < 12) || (13 <= hour && hour < 17)) { //시스템의 상태를 주간으로 바꾼다.
            context.changeState(DayState.getInstance());
        }
    }

    public void doUse(Context context) { //금고사용
        context.recordLog("금고사용(야식시간)");
        context.callSecurityCenter("비상:야식시간 금고사용!");
    }

    public void doAlarm(Context context) { //비상벨
        context.callSecurityCenter("비상벨(야식시간)");
    } //비상벨

    public void doPhone(Context context) { //일반통화
        context.recordLog("야식시간 통화 녹음");
    } //일반통화

    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV: Off");
    } //CCTV

    public String toString() { //문자열 표현
        return "[야식시간]";
    } //문자열 표현
}
