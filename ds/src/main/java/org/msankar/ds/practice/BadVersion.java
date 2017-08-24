package org.msankar.ds.practice;

public class BadVersion {
	private static final int FIRST_BAD_VER = 86;

	public static void main(String[] args) {
		System.out.println(firstBadVersion(200));
	}

    public static int firstBadVersion(int versions) {
    	int lo = 0; int high = versions;
    	while(lo < high) {
    		int mid = lo+(high-lo)/2;
    		if (isBadVersion(mid)) {
    			high = mid;
    		} else {
    			lo = mid+1;
    		}
    	}
    	return high;
    }

    public static boolean isBadVersion(int version) {
    	if (version >= FIRST_BAD_VER) {
    		return true;
    	}
    	return false;
    }
}
