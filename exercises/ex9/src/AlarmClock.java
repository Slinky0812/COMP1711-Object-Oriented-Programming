public class AlarmClock extends Clock{
    private int alarmHours;
    private int alarmMinutes;

    public AlarmClock() {
        super(0, 0, 0);
    }

    public AlarmClock(int h, int m) {
        super(h, m, 0);
    }

    public AlarmClock(int h, int m, int s) {
        super(h, m, s);
    }

    public int getAlarmHours() {
        return alarmHours;
    }

    public int getAlarmMinutes() {
        return alarmMinutes;
    }

    public void setAlarm(int h, int m) {
        if (h > HOURS_IN_A_DAY) {
            throw new IllegalArgumentException("Invalid Alarm Hours");
        }

        if (m > MINUTES_IN_AN_HOUR) {
            throw new IllegalArgumentException("Invalid Alarm Minutes");
        }

        alarmHours = h;
        alarmMinutes = m;
    }

    public boolean isRinging() {
        if (alarmHours == getHours() && alarmMinutes == getMinutes()) {
            while (getSeconds() < 15) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        if (isRinging()) {
            System.out.println(this + " - WAKE UP!");
        } else {
            System.out.println(this);
        }
    }
}
