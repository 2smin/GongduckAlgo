package programmers;

public class PG42839 {

    public static void main(String[] args) {

        int count = solution("011");
        System.out.println(count);
    }

    public static int solution(String numbers) {

        int[] numCount = makeCountArr(numbers);

        //소수배열의 길이를 산정한다
        int length = 1;
        for (int i = 0; i < numbers.length(); i++) {
            length *= 10;
        }

        int[] primeNum = makePrimeArr(length);

        //가능한 수 세기
        int count = 0;

        //범위 내 소수 돌면서
        for (int i = 2; i < primeNum.length; i++) {

            //소수가 아닌건 패스
            if (primeNum[i] == 0) {
                continue;
            }

            //소수를 str로 바꿔서 cnt 배열 만들기
            int[] primeCnt = makeCountArr(primeNum[i] + "");

            //만들 수 있는지 체크
            boolean isPrimeNum = true;

            //조각갯수로 만들 수 있는지 체크
            for (int j = 0; j < primeCnt.length; j++) {
                if (primeCnt[j] > numCount[j]) {
                    isPrimeNum = false;
                    break;
                }
            }

            //만들 수 있으면 count 더하기
            if (isPrimeNum) {
                count++;
            }
        }
        return count;
    }

    public static int[] makePrimeArr(int length) {

        //소수배열만들기
        int[] primeNum = new int[length];

        for (int i = 2; i < length; i++) {
            primeNum[i] = i;
        }

        for (int i = 2; i < primeNum.length; i++) {
            if (primeNum[i] == 0) {
                continue;
            }
            ;
            for (int j = i + i; j < primeNum.length; j += i) {
                primeNum[j] = 0;
            }
        }

        return primeNum;
    }

    public static int[] makeCountArr(String numbers) {

        int[] numCount = new int[10];

        for (int i = 0; i < numbers.length(); i++) {
            numCount[numbers.charAt(i) - 48]++;
        }

        return numCount;
    }


}
