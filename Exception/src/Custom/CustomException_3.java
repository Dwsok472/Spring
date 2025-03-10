package Custom;

class MinusException extends RuntimeException {
    public MinusException() {
        super();
    }
    public MinusException(String message){
        super(message);
    }
}
class OverException extends RuntimeException {
    public OverException() {
        super();
    }
    public OverException(String message) {
        super(message);
    }
}

class AA {
    // 여러개의 발생 가능한 예외를 함께 던질 수 있음
    void checkScore(int score) throws MinusException,OverException {
        if (score < 0) {
            throw new MinusException("예외발생: 음수값입력");
        } else if (score > 100) {
            throw new OverException("예외발생: 100점 초과");
        } else {
            System.out.println("정상적인 값 : " + score);
        }
    }
        void caller1(int score) {
            caller2(score);
        }
        void caller2(int score) {
            checkScore(score);
        }
    }

public class CustomException_3 {
    public static void main(String[] args) {
        AA a = new AA();
        try {
            a.checkScore(85);
            a.checkScore(150);
            a.checkScore(-1);
        } catch (MinusException | OverException e) {
            System.out.println(e.getMessage());
            for (StackTraceElement element : e.getStackTrace()) {
                System.out.println(element);
            }
        }
    }
}
