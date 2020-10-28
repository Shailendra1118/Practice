/**
 * 
 */
package com.basic.hkre.krypc;

import java.io.File;
import java.util.Scanner;

/**
 * @author Shailendra
 *
 */
public class TrailHckr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File(
					"D:/Keppler/Practice/src/com/basic/hkre/krypc/trail.txt"));

			int tc = scan.nextInt();
			for (int i = 0; i < tc; i++) {
				int fcAge = scan.nextInt();
				int fcPos = scan.nextInt();

				int scAge = scan.nextInt();
				int scPos = scan.nextInt();
				int turn = -1; // 1 fc 2 sc
				// older cat always play first
				if (fcAge > scAge) {
					turn = 1;
					// fcPos = fcPos + 2;
					// turn = 2;
				} else {
					turn = 2;
					// scPos = scPos + 2;
					// turn = 1;
				}

				while (fcPos < scPos) {
					if (turn == 1) {
						if (fcPos + 1 == scPos) {
							System.out.println(0);
							break;
						}

						if (fcPos + 2 != scPos) {
							fcPos = fcPos + 2;
						} else {
							fcPos++;
						}
						turn = 2;
					}

					if (turn == 2) {
						if (scPos - 1 == fcPos) {
							System.out.println(1);
							break;
						}

						if (scPos - 2 != fcPos) {
							scPos = scPos - 2;
						} else {
							scPos--;
						}
						turn = 1;
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
