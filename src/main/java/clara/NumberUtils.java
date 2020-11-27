package clara;

import java.util.ArrayList;
import java.util.List;

public class NumberUtils {

    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int n = 2; n < num; n++) {
            if (num % n == 0) {
                return false;
            }
        }
        return true;
    }

    public int sum(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        int numSum = 0;
        for (int i: nums) {
            numSum += i;
        }
        return numSum;
    }

    public int min(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        int currentMin = nums[0];
        for (int i: nums) {
            if (i < currentMin) {
                currentMin = i;
            }
        }
        return currentMin;
    }

    public int max(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        int currentMax = nums[0];
        for (int i: nums) {
            if (i > currentMax) {
                currentMax = i;
            }
        }
        return currentMax;
    }

    public int recursiveSum(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int lastItem = nums[nums.length - 1];
        int[] newArray = new int[nums.length - 1];
        System.arraycopy(nums, 0, newArray, 0, nums.length - 1);

        return lastItem + recursiveSum(newArray);

    }

    public int recursiveMin(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int lastItem = nums[nums.length - 1];
        int[] newArray = new int[nums.length - 1];
        System.arraycopy(nums, 0, newArray, 0, nums.length - 1);

        int result = recursiveMin(newArray);

        return Math.min(lastItem, result);

    }

    public int recursiveMax(int[] nums) {
        if (nums.length == 0) {
            throw new IllegalArgumentException("Please enter an array with at least one element");
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int lastItem = nums[nums.length - 1];
        int[] newArray = new int[nums.length - 1];
        System.arraycopy(nums, 0, newArray, 0, nums.length - 1);

        int result = recursiveMax(newArray);

        return Math.max(lastItem, result);

    }

    public int findFactorial(int num) {

        int currentProduct = 1;
        if (num < 0) {
            throw new IllegalArgumentException("Please enter a non-negative number");
        }
        for (int i = 1; i <= num; i++) {
            currentProduct = currentProduct * i;
        }

        return currentProduct;
    }

    public int recursiveFindFactorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Please enter a non-negative number");
        }
        if (num == 0 || num == 1) {
            return 1;
        }

        int oneLess = num - 1;
        return num * recursiveFindFactorial(oneLess);
    }

    public List<Integer> findFactors(int num) {
        if (num < 2) {
            throw new IllegalArgumentException("Please enter an integer greater than 1");
        }
        List<Integer> factorlist = new ArrayList<>();
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                factorlist.add(i);
            }
        }
        return factorlist;
    }


}