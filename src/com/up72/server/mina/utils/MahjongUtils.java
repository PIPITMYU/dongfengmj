package com.up72.server.mina.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.up72.game.constant.Cnst;
import com.up72.game.dto.resp.Player;
import com.up72.server.mina.function.TCPGameFunctions;

/**
 * Created by Administrator on 2017/6/29.
 */
public class MahjongUtils {

	public static Map<Integer, List<Integer[][]>> staticPais = new HashMap<>();
	public static List<Integer[][]> list1 = new ArrayList<>();
	public static List<Integer[][]> list2 = new ArrayList<>();
	public static List<Integer[][]> list3 = new ArrayList<>();
	public static List<Integer[][]> list4 = new ArrayList<>();
	static {
		list1.add(new Integer[][] { { 1, 1 } });
		list1.add(new Integer[][] { { 1, 1 } });
		list1.add(new Integer[][] { { 1, 1 } });
		list1.add(new Integer[][] { { 2, 1 } });
		list1.add(new Integer[][] { { 2, 1 } });
		list1.add(new Integer[][] { { 2, 1 } });
		list1.add(new Integer[][] { { 2, 1 } });
		list1.add(new Integer[][] { { 3, 2 } });
		list1.add(new Integer[][] { { 3, 2 } });
		list1.add(new Integer[][] { { 3, 2 } });
		list1.add(new Integer[][] { { 3, 2 } });
		list1.add(new Integer[][] { { 5, 3 } });
		list1.add(new Integer[][] { { 1, 2 } });
		list2.add(new Integer[][] { { 1, 1 } });
		list2.add(new Integer[][] { { 1, 1 } });
		list2.add(new Integer[][] { { 1, 5 } });
		list2.add(new Integer[][] { { 2, 1 } });
		list2.add(new Integer[][] { { 2, 2 } });
		list2.add(new Integer[][] { { 2, 3 } });
		list2.add(new Integer[][] { { 5, 1 } });
		list2.add(new Integer[][] { { 5, 2 } });
		list2.add(new Integer[][] { { 5, 3 } });
		list2.add(new Integer[][] { { 4, 1 } });
		list2.add(new Integer[][] { { 4, 2 } });
		list2.add(new Integer[][] { { 4, 3 } });
		list2.add(new Integer[][] { { 4, 4 } });
		list3.add(new Integer[][] { { 1, 1 } });
		list3.add(new Integer[][] { { 1, 1 } });
		list3.add(new Integer[][] { { 1, 3 } });
		list3.add(new Integer[][] { { 2, 2 } });
		list3.add(new Integer[][] { { 2, 2 } });
		list3.add(new Integer[][] { { 1, 3 } });
		list3.add(new Integer[][] { { 5, 1 } });
		list3.add(new Integer[][] { { 5, 2 } });
		list3.add(new Integer[][] { { 5, 3 } });
		list3.add(new Integer[][] { { 3, 2 } });
		list3.add(new Integer[][] { { 5, 1 } });
		list3.add(new Integer[][] { { 5, 2 } });
		list3.add(new Integer[][] { { 5, 3 } });
		list4.add(new Integer[][] { { 1, 1 } });
		list4.add(new Integer[][] { { 1, 1 } });
		list4.add(new Integer[][] { { 1, 1 } });
		list4.add(new Integer[][] { { 2, 1 } });
		list4.add(new Integer[][] { { 2, 2 } });
		list4.add(new Integer[][] { { 2, 3 } });
		list4.add(new Integer[][] { { 3, 1 } });
		list4.add(new Integer[][] { { 3, 2 } });
		list4.add(new Integer[][] { { 3, 3 } });
		list4.add(new Integer[][] { { 4, 1 } });
		list4.add(new Integer[][] { { 4, 1 } });
		list4.add(new Integer[][] { { 4, 1 } });
		list4.add(new Integer[][] { { 2, 2 } });

		staticPais.put(Cnst.WIND_EAST, list1);
		staticPais.put(Cnst.WIND_SOUTH, list2);
		staticPais.put(Cnst.WIND_WEST, list3);
		staticPais.put(Cnst.WIND_NORTH, list4);
	}
	/**
	 * 检测组合数
	 * @param args
	 */
	public static void main(String[] args) {
		// 1---34 位 每位4张 取10张一共（1取3张，因为为混）
		
		String name="arr";//初始化牌的数组前缀名字
		Integer cNum=10;//需要检测的牌名字
		Map<String ,int[]> map=new HashMap<String, int[]>();
		//初始化牌
		for (int i = 1; i <= 34; i++) {
			if(i==1){
				map.put(name+i, new int[]{i,i,i});
			}else{
				map.put(name+i, new int[]{i,i,i,i});
			}
		}
		checkHowNum(map,34,cNum);

	}
	

	private static void checkHowNum(Map<String, int[]> map,Integer num, Integer cNum) {
		String name="arr";//初始化牌的数组前缀名字
		for (int i = num; i <= 34; num++) {
			
			
			
			
		}
	}


	public static Boolean checkHu(Player p, Integer[][] pai) {
		Boolean hu = false;
		if (pai != null) {
			Integer[][] pai1 = new Integer[][] { { pai[0][0], pai[0][1] } };
			p.getCurrentMjList().add(
					new Integer[][] { { pai1[0][0], pai1[0][1] } });// 加入牌参数
			p.setCurrentMjList(paiXu(p.getCurrentMjList()));
			hu = checkHu(p, null);
			for (int i = 0; i < p.getCurrentMjList().size(); i++) {// 移除pai参数
				if (p.getCurrentMjList().get(i)[0][0].equals(pai1[0][0])
						&& p.getCurrentMjList().get(i)[0][1].equals(pai1[0][1])) {
					p.getCurrentMjList().remove(i);
					break;
				}
			}
		} else {
			if (!checkHuRule(p)) {
				return false;
			}
			List<Integer[][]> playerPais = p.getCurrentMjList();
			List<Integer[][]> list = new ArrayList<>();
			for (int i = 0; i < playerPais.size(); i++) {
				list.add(new Integer[][] { { playerPais.get(i)[0][0],
						playerPais.get(i)[0][1] } });
			}
			hu = checkHu(list);
		}
		return hu;
	}

	/**
	 * 参数pai为检测点胡用的 1、不可缺幺九，箭牌风牌可以抵幺九 2、至少有叉牌或者杠牌，有中发白可免叉。（叉牌是三张一样的，碰的也算，也可以是杠牌）
	 * 3、必须三色全（吃碰杠也算） 4、如果手中只有飘胡，才能手把一
	 */
	private static boolean checkHuRule(Player p) {
		if (p.getCurrentMjList().size() != 2
				&& p.getCurrentMjList().size() != 5
				&& p.getCurrentMjList().size() != 8
				&& p.getCurrentMjList().size() != 11
				&& p.getCurrentMjList().size() != 14) {// 牌数检测
			return false;
		}
		boolean hasChaOrGang = false;
		// 先把玩家所有吃碰杠手牌都添加到list中，用list的contains方法检测是否缺牌
		List<String> list = new ArrayList<>();
		for (int i = 0; i < p.getCurrentMjList().size(); i++) {
			list.add(p.getCurrentMjList().get(i)[0][0] + "_"
					+ p.getCurrentMjList().get(i)[0][1]);
		}
		if (p.getChiList() != null && p.getChiList().size() > 0) {
			for (int i = 0; i < p.getChiList().size(); i++) {
				list.add(p.getChiList().get(i).getL().get(0)[0][0] + "_"
						+ p.getChiList().get(i).getL().get(0)[0][1]);
				list.add(p.getChiList().get(i).getL().get(1)[0][0] + "_"
						+ p.getChiList().get(i).getL().get(1)[0][1]);
				list.add(p.getChiList().get(i).getL().get(2)[0][0] + "_"
						+ p.getChiList().get(i).getL().get(2)[0][1]);
			}
		}
		if (p.getPengList() != null && p.getPengList().size() > 0) {
			hasChaOrGang = true;
			for (int i = 0; i < p.getPengList().size(); i++) {
				list.add(p.getPengList().get(i).getL().get(0)[0][0] + "_"
						+ p.getPengList().get(i).getL().get(0)[0][1]);
			}
		}
		if (p.getGangListType1() != null && p.getGangListType1().size() > 0) {
			hasChaOrGang = true;
			list.add("5_1");
			list.add("5_2");
			list.add("5_3");
		}
		if (p.getGangListType2() != null && p.getGangListType2().size() > 0) {
			hasChaOrGang = true;
			list.add("4_1");
			list.add("4_2");
			list.add("4_3");
			list.add("4_4");
		}
		if (p.getGangListType3() != null && p.getGangListType3().size() > 0) {
			hasChaOrGang = true;
			for (int i = 0; i < p.getGangListType3().size(); i++) {
				list.add(p.getGangListType3().get(i).getL().get(0)[0][0] + "_"
						+ p.getGangListType3().get(i).getL().get(0)[0][1]);
			}
		}
		if (p.getGangListType4() != null && p.getGangListType4().size() > 0) {
			hasChaOrGang = true;
			for (int i = 0; i < p.getGangListType4().size(); i++) {
				list.add(p.getGangListType4().get(i).getL().get(0)[0][0] + "_"
						+ p.getGangListType4().get(i).getL().get(0)[0][1]);
			}
		}
		if (p.getGangListType5() != null && p.getGangListType5().size() > 0) {
			hasChaOrGang = true;
			for (int i = 0; i < p.getGangListType5().size(); i++) {
				list.add(p.getGangListType5().get(i).getL().get(0)[0][0] + "_"
						+ p.getGangListType5().get(i).getL().get(0)[0][1]);
			}
		}
		// 幺九检测
		List<String> check = new ArrayList<>();
		check.add("1_1");
		check.add("1_9");
		check.add("2_1");
		check.add("2_9");
		check.add("3_1");
		check.add("3_9");
		check.add("4_1");
		check.add("4_2");
		check.add("4_3");
		check.add("4_4");
		check.add("5_1");
		check.add("5_2");
		check.add("5_3");
		boolean hasYJ = false;
		for (String s : check) {
			if (list.contains(s)) {
				hasYJ = true;
				break;
			}
		}
		if (!hasYJ) {
			return false;
		}

		// 三色全检测
		check = new ArrayList<>();
		check.add("1_");
		check.add("2_");
		check.add("3_");
		for (String ch : check) {
			boolean allColor = false;
			for (String mj : list) {
				if (mj.contains(ch)) {
					allColor = true;
					break;
				}
			}
			if (!allColor) {
				return false;
			}
		}
		if (p.getCurrentMjList().size() == 2
				&& (p.getGangListType1() == null || p.getGangListType1().size() == 0)
				&& (p.getGangListType2() == null || p.getGangListType2().size() == 0)
				&& (p.getGangListType5() == null || p.getGangListType5().size() == 0)) {// 飘
			if (!(p.getChiList() == null || p.getChiList().size() == 0)) {
				return false;
			}
		}
		if (!hasChaOrGang && !checkChaInShouPai(p.getCurrentMjList())) {// 在非手牌中检测不到碰或者杠，需要检测手牌中是否有叉
			// 检测手牌中是否有叉，即三个一样的，那就说明，把三张一样的拿出来之后，剩下的牌也能胡，就算有叉

			// 新增规则，如果，手中有中发白的将，也可以顶刻
			boolean hasZi = false;// 有没有字牌
			for (Integer[][] pai : p.getCurrentMjList()) {
				if (pai[0][0].equals(5)) {
					hasZi = true;
					break;
				}
			}
			if (!hasZi) {
				return false;
			}

		}
		return true;
	}

	private static Boolean checkChaInShouPai(List<Integer[][]> playerPais) {
		boolean result = false;
		Set<String> set = new HashSet<>();
		for (int i = 0; i < playerPais.size(); i++) {
			if (!set.contains(playerPais.get(i)[0][0] + "_"
					+ playerPais.get(i)[0][1])) {
				if (checkPaiNum(playerPais, playerPais.get(i), i) >= 3) {
					set.add(playerPais.get(i)[0][0] + "_"
							+ playerPais.get(i)[0][1]);
					Integer[][] pai3 = playerPais.get(i + 2);
					Integer[][] pai2 = playerPais.get(i + 1);
					Integer[][] pai1 = playerPais.get(i);
					playerPais.remove(i + 2);
					playerPais.remove(i + 1);
					playerPais.remove(i);
					if (checkHu(playerPais)) {
						playerPais.add(i, pai1);
						playerPais.add(i + 1, pai2);
						playerPais.add(i + 2, pai3);
						return true;
					} else {
						playerPais.add(i, pai1);
						playerPais.add(i + 1, pai2);
						playerPais.add(i + 2, pai3);
					}
				}
			}

		}

		return result;
	}

	/**
	 * 胡牌检测 palyerPai必须为排好序的
	 * palyerPai的length必须符合3n+2(2,5,8,11,14)的格式，返回是true/false
	 * 
	 * @param playerPais
	 * @return
	 */
	private static Boolean checkHu(List<Integer[][]> playerPais) {
		if (playerPais.size() != 2 && playerPais.size() != 5
				&& playerPais.size() != 8 && playerPais.size() != 11
				&& playerPais.size() != 14) {
			return false;
		}
		playerPais = paiXu(playerPais);
		// 首先找出一个对牌（出现的次数大于2，都有可能做将对）
		Set<String> duiSet = new HashSet<>();// 存放当过对牌的集合
		// List<List<Integer[][]>> huType = new ArrayList<>();//计算分数的时候，可能用到
		for (int i = 0; i < playerPais.size(); i++) {
			if (checkPaiNum(playerPais, playerPais.get(i), 0) >= 2) {// 可能是对子
				if (!duiSet.contains(playerPais.get(i)[0][0] + "_"
						+ playerPais.get(i)[0][1])) {
					duiSet.add(playerPais.get(i)[0][0] + "_"
							+ playerPais.get(i)[0][1]);
					// 保存并移除相邻的两张
					Integer[][] iPai = playerPais.get(i);
					Integer[][] iPai1 = playerPais.get(i + 1);
					playerPais.remove(i + 1);
					playerPais.remove(i);
					// 剩下的牌里面只需要检测3n部分，也就是3个相同的（暗刻），或者3个相连的
					// 如果不是这种结构，说明上面检测的这个对子不合适，需要还原移除的元素，重新检测对子
					// 在剩余的牌中，继续检测每张牌出现的次数，
					// 每张牌可能的次数结果为1,2,3,4
					// 出现1次，必须与后面的组成顺子
					// 出现两次，必须与后面的组成顺子（小七对除外，会在总的循环外检测duiSet的size，如果等于7，说明是小七对）
					// 出现3次，两种可能，一：为暗刻；二：三张分别于后面的牌组成顺子
					// 出现4次，必须与后面的两张组成顺子，然后，再检测剩下3张的状态

					// List<Integer[][]> hu = new ArrayList<>();//计算分数的时候，可能用到
					if (heartCheckHu(playerPais)) {
						playerPais.add(i, iPai);
						playerPais.add(i + 1, iPai1);
						return true;
					} else {
						playerPais.add(i, iPai);
						playerPais.add(i + 1, iPai1);
					}
				}
			}
		}
		return false;
	}

	/**
	 * 胡牌检测--检测3n部分 传入除去对子的牌的集合，即检测3n部分
	 * 
	 * @param playerPais
	 * @return
	 */
	private static Boolean heartCheckHu(List<Integer[][]> playerPais) {
		List<Integer[][]> currentList = new ArrayList<>();
		currentList.addAll(playerPais);

		for (int j = 0; j < currentList.size(); j++) {
			Integer num = checkPaiNum(currentList, currentList.get(j), j);// 可以看成是顺子的个数
			if (num < 3) {
				if (checkShunZi(currentList, j, num)) {
					// 移除已经组成的顺子，然后递归
					return heartCheckHu(removeShunZi(currentList,
							currentList.get(j), num));
				} else {
					return false;
				}
			} else {
				Integer[][] iPai = currentList.get(j);
				Integer[][] iPai1 = currentList.get(j + 1);
				Integer[][] iPai2 = currentList.get(j + 2);
				currentList.remove(j + 2);
				currentList.remove(j + 1);
				currentList.remove(j);
				if (heartCheckHu(currentList)) {// 按照暗刻来计算胡牌
					return true;
				} else {// 按照三个顺子来计算胡牌
					currentList.add(j, iPai);
					currentList.add(j + 1, iPai1);
					currentList.add(j + 2, iPai2);
					if (checkShunZi(currentList, j, num)) {
						return heartCheckHu(removeShunZi(currentList,
								currentList.get(j), num));
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * 胡牌检测--移除顺子部分 把可以组成顺子的移除掉，返回移除后的list
	 * 
	 * @param playerPais
	 * @param pai
	 * @param num
	 * @return
	 */
	private static List<Integer[][]> removeShunZi(List<Integer[][]> playerPais,
			Integer[][] pai, Integer num) {
		int fn = 0, sn = 0, tn = 0;
		for (int k = 0; k < playerPais.size(); k++) {
			if (fn < num && pai[0][0].equals(playerPais.get(k)[0][0])
					&& pai[0][1].equals(playerPais.get(k)[0][1])) {
				fn++;
				playerPais.remove(k--);
			} else if (sn < num && pai[0][0].equals(playerPais.get(k)[0][0])
					&& playerPais.get(k)[0][1].equals(pai[0][1] + 1)) {
				sn++;
				playerPais.remove(k--);
			} else if (tn < num && pai[0][0].equals(playerPais.get(k)[0][0])
					&& playerPais.get(k)[0][1].equals(pai[0][1] + 2)) {
				tn++;
				playerPais.remove(k--);
			}
		}
		return playerPais;
	}

	/**
	 * 胡牌检测--检测顺子 传入牌的集合，以及要检测的开始位置，和顺子个数 检测顺子时首先要检测牌型，不能为风牌和箭牌 返回是否是顺子
	 * 
	 * @param playerPais
	 * @param position
	 * @param num
	 * @return
	 */
	private static Boolean checkShunZi(List<Integer[][]> playerPais,
			Integer position, Integer num) {
		if (playerPais.get(position)[0][0].equals(4)
				|| playerPais.get(position)[0][0].equals(5)) {
			return false;
		}
		if ((position + 3 * num - 1) < playerPais.size()) {
			List<Integer> firstPosi = new ArrayList<>();
			List<Integer> secondPosi = new ArrayList<>();
			List<Integer> thirdPosi = new ArrayList<>();
			for (int i = position; i < playerPais.size(); i++) {
				if (playerPais.get(position)[0][0]
						.equals(playerPais.get(i)[0][0])
						&& playerPais.get(position)[0][1].equals(playerPais
								.get(i)[0][1])) {
					firstPosi.add(i);
				} else if (playerPais.get(position)[0][0].equals(playerPais
						.get(i)[0][0])
						&& playerPais.get(i)[0][1].equals(playerPais
								.get(position)[0][1] + 1)) {
					secondPosi.add(i);
				} else if (playerPais.get(position)[0][0].equals(playerPais
						.get(i)[0][0])
						&& playerPais.get(i)[0][1].equals(playerPais
								.get(position)[0][1] + 2)) {
					thirdPosi.add(i);
				}
			}
			if (firstPosi.size() < num || secondPosi.size() < num
					|| thirdPosi.size() < num) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 检测单个牌出现的次数 传入牌的集合，以及要统计的拍出现次数的牌，然后返回出现的次数
	 * 
	 * @param paiList
	 * @param pai
	 * @return
	 */
	private static Integer checkPaiNum(List<Integer[][]> paiList,
			Integer[][] pai, Integer start) {
		Integer num = 0;
		for (int i = start; i < paiList.size(); i++) {
			if (paiList.get(i)[0][0].equals(pai[0][0])
					&& paiList.get(i)[0][1].equals(pai[0][1])) {
				num++;
			}
		}
		return num;
	}

	/**
	 * 排序 给出一组牌 返回按照类型以及大小拍好顺序的牌
	 * 
	 * @param pais
	 * @return
	 */
	public static List<Integer[][]> paiXu(List<Integer[][]> pais) {
		Integer[] arrays = new Integer[pais.size()];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = pais.get(i)[0][0] * 10 + pais.get(i)[0][1];
		}
		Arrays.sort(arrays);
		for (int i = 0; i < arrays.length; i++) {
			pais.get(i)[0][0] = arrays[i] / 10;
			pais.get(i)[0][1] = arrays[i] % 10;
		}
		return pais;
	}

	/**
	 * 吃牌检测 如果玩家的牌只有四张，就不能吃！吃牌的时候，手里的牌必须大于4
	 * 
	 * 
	 * @param p
	 * @param pai
	 */
	public static List<Integer[][]> checkChi(Player p, Integer[][] pai) {
		if (pai[0][0].equals(4) || pai[0][0].equals(5)) {
			return null;
		}
		if ((p.getGangListType1() == null || p.getGangListType1().size() == 0)
				&& (p.getGangListType2() == null || p.getGangListType2().size() == 0)
				&& p.getCurrentMjList().size() < 5) {// 牌数少于4或者是风牌或者是箭牌，不能吃
			return null;
		}
		Integer[][] pai1 = new Integer[][] { { pai[0][0], pai[0][1] } };
		List<Integer[][]> result = new ArrayList<>();
		List<Integer[][]> sameType = new ArrayList<>();// 存放相同牌型的牌的集合
		for (int i = 0; i < p.getCurrentMjList().size(); i++) {
			if (pai1[0][0].equals(p.getCurrentMjList().get(i)[0][0])) {// 相同牌型
				boolean hasPai = false;
				for (int j = 0; j < sameType.size(); j++) {
					if (sameType.get(j)[0][0].equals(p.getCurrentMjList()
							.get(i)[0][0])
							&& sameType.get(j)[0][1].equals(p
									.getCurrentMjList().get(i)[0][1])) {
						hasPai = true;
					}
				}
				if (!hasPai) {
					sameType.add(new Integer[][] { {
							p.getCurrentMjList().get(i)[0][0],
							p.getCurrentMjList().get(i)[0][1] } });
				}
			}
		}
		// 如果，pai的值为1，要判断+1+2；
		// 如果，pai的值为9，要判断-1-2；
		// 如果，pai的值其他，要判断+1+2；-1-2；+1-1
		// 把所有牌型一致的牌两两组合，放入templete中，然后跟上述规则对比
		List<Integer[][]> templete = new ArrayList<>();
		for (int i = 0; i < sameType.size(); i++) {
			for (int j = i + 1; j < sameType.size(); j++) {
				templete.add(new Integer[][] {
						{ sameType.get(i)[0][0], sameType.get(i)[0][1] },
						{ sameType.get(j)[0][0], sameType.get(j)[0][1] } });
			}
		}
		for (int i = 0; i < templete.size(); i++) {
			if ((templete.get(i)[0][1].equals(pai1[0][1] + 1) && templete
					.get(i)[1][1].equals(pai1[0][1] + 2)) || // +1+2
					(templete.get(i)[0][1].equals(pai1[0][1] + 2) && templete
							.get(i)[1][1].equals(pai1[0][1] + 1)) || // +2+1
					(templete.get(i)[0][1].equals(pai1[0][1] - 1) && templete
							.get(i)[1][1].equals(pai1[0][1] - 2)) || // -1-2
					(templete.get(i)[0][1].equals(pai1[0][1] - 2) && templete
							.get(i)[1][1].equals(pai1[0][1] - 1)) || // -2-1
					(templete.get(i)[0][1].equals(pai1[0][1] - 1) && templete
							.get(i)[1][1].equals(pai1[0][1] + 1)) || // -1+1
					(templete.get(i)[0][1].equals(pai1[0][1] + 1) && templete
							.get(i)[1][1].equals(pai1[0][1] - 1))) {// +1-1
				result.add(templete.get(i));
			}
		}
		return result.size() > 0 ? result : null;
	}

	/**
	 * 碰牌检测 如果玩家只有四张牌，需要检测是不是飘， 如果是飘，继续检测能不能碰，如果不是飘，就不能碰
	 * 
	 * @param p
	 * @param pai
	 * @return
	 */
	public static List<Integer[][]> checkPeng(Player p, Integer[][] pai) {
		List<Integer[][]> result = new ArrayList<>();
		if (canCheckActions(p)) {// 飘牌检测
			result = pengGangCheck(p.getCurrentMjList(), pai, 3);
		}
		return result != null && result.size() > 0 ? result : null;
	}

	/**
	 * 杠牌检测 必须先检测飘的情况 1.起手牌检测 pai参数为null 特殊杠 正常杠检测 2.游戏中检测 特殊杠 正常杠 3.手牌与碰牌集合检测
	 * 
	 * @param p
	 * @param pai
	 * @return
	 */
	public static List<Integer[][]> checkGang(Player p, Integer[][] pai) {
		// if (p.getCurrentMjList().size()<=2){
		// return null;
		// }
		List<Integer[][]> result = new ArrayList<>();
		if (canCheckActions(p)) {// 检测能不能杠
			List<Integer[][]> list1 = checkSpecialGang(p, p.getCurrentMjList(),
					pai);
			if (list1 != null)
				result.addAll(list1);
			List<Integer[][]> list2 = pengGangCheck(p.getCurrentMjList(), pai,
					4);
			if (list2 != null)
				result.addAll(list2);
		} else {
			// newAdd 在手把一的问题上，暗杠和特殊杠可以手把一
			if ((p.getCurrentMjList().size() == 4 || p.getCurrentMjList()
					.size() == 5) && pai == null) {// 手牌在4或者5张的时候，是可以检测暗杠的
				list2 = pengGangCheck(p.getCurrentMjList(), pai, 4);
				if (list2 != null)
					result.addAll(list2);
			}
		}

		if (pai == null) {
			// 需要检测手中的牌与碰牌集合有没有能组成杠的
			if (p.getPengList() != null && p.getPengList().size() > 0) {
				for (int i = 0; i < p.getPengList().size(); i++) {
					List<Integer[][]> list = p.getPengList().get(i).getL();
					for (int j = 0; j < p.getCurrentMjList().size(); j++) {
						if (p.getCurrentMjList().get(j)[0][0].equals(list
								.get(0)[0][0])
								&& p.getCurrentMjList().get(j)[0][1]
										.equals(list.get(0)[0][1])) {
							result.add(new Integer[][] { {
									p.getCurrentMjList().get(j)[0][0],
									p.getCurrentMjList().get(j)[0][1] } });
							break;
						}
					}
				}
			}
			/* 在checkSpecialGang方法中检测的很详细，在此不需要 */
			// //检测手牌中能不能跟初始特殊杠成杠
			// if (p.getGangListType1()!=null&&p.getGangListType1().size()>0)
			// {//有初始中发白杠
			// for(int i=0;i<p.getCurrentMjList().size();i++){
			// if (p.getCurrentMjList().get(i)[0][0]==5){
			// result.add(new
			// Integer[][]{{p.getCurrentMjList().get(i)[0][0],p.getCurrentMjList().get(i)[0][1]}});
			// }
			// }
			// }
			// if (p.getGangListType2()!=null&&p.getGangListType2().size()>0)
			// {//有初始东南西北杠
			// for(int i=0;i<p.getCurrentMjList().size();i++){
			// if (p.getCurrentMjList().get(i)[0][0]==4){
			// result.add(new
			// Integer[][]{{p.getCurrentMjList().get(i)[0][0],p.getCurrentMjList().get(i)[0][1]}});
			// }
			// }
			// }
		}
		return result.size() > 0 ? result : null;
	}

	/**
	 * 特殊杠检测
	 * 
	 * @param p
	 * @param palyerPai
	 * @param pai
	 * @return
	 */
	private static List<Integer[][]> checkSpecialGang(Player p,
			List<Integer[][]> palyerPai, Integer[][] pai) {
		List<Integer[][]> result = new ArrayList<>();
		if (pai == null) {
			if ((p.getZhuaPaiNum() <= 1 || p.getChuPaiNum().equals(0))
					&& (p.getChiList() == null || p.getChiList().size() == 0)
					&& (p.getPengList() == null || p.getPengList().size() == 0)) {// 得是抓的第一张手牌才行,且不得有吃碰

				// 检测中发白
				if (p.getGangListType1() != null
						&& p.getGangListType1().size() > 0) {
					for (int i = 0; i < palyerPai.size(); i++) {
						if (palyerPai.get(i)[0][0].equals(5)) {
							result.add(new Integer[][] { {
									palyerPai.get(i)[0][0],
									palyerPai.get(i)[0][1] } });
						}
					}
				} else {
					List<String> list = new ArrayList<>();
					for (int i = 0; i < palyerPai.size(); i++) {
						if (palyerPai.get(i)[0][0].equals(5)) {
							list.add(palyerPai.get(i)[0][0] + "_"
									+ palyerPai.get(i)[0][1]);
						}
					}
					if (list.contains("5_1") && list.contains("5_2")
							&& list.contains("5_3")) {
						result.add(new Integer[][] { { 5, 1 }, { 5, 2 },
								{ 5, 3 } });
					}
				}

				// 检测东南西北
				if (p.getGangListType2() != null
						&& p.getGangListType2().size() > 0) {
					for (int i = 0; i < palyerPai.size(); i++) {
						if (palyerPai.get(i)[0][0].equals(4)) {
							result.add(new Integer[][] { {
									palyerPai.get(i)[0][0],
									palyerPai.get(i)[0][1] } });
						}
					}
				} else {
					List<String> list = new ArrayList<>();
					for (int i = 0; i < palyerPai.size(); i++) {
						if (palyerPai.get(i)[0][0].equals(4)) {
							list.add(palyerPai.get(i)[0][0] + "_"
									+ palyerPai.get(i)[0][1]);
						}
					}
					if (list.contains("4_1") && list.contains("4_2")
							&& list.contains("4_3") && list.contains("4_4")) {
						result.add(new Integer[][] { { 4, 1 }, { 4, 2 },
								{ 4, 3 }, { 4, 4 } });
					}
				}

			} else {
				if (p.getGangListType1() != null
						&& p.getGangListType1().size() > 0) {
					for (int i = 0; i < palyerPai.size(); i++) {
						if (palyerPai.get(i)[0][0].equals(5)) {
							result.add(new Integer[][] { {
									palyerPai.get(i)[0][0],
									palyerPai.get(i)[0][1] } });
						}
					}
				}
				if (p.getGangListType2() != null
						&& p.getGangListType2().size() > 0) {
					for (int i = 0; i < palyerPai.size(); i++) {
						if (palyerPai.get(i)[0][0].equals(4)) {
							result.add(new Integer[][] { {
									palyerPai.get(i)[0][0],
									palyerPai.get(i)[0][1] } });
						}
					}
				}

			}
		}
		// else{
		// Integer[][] pai1 = new Integer[][]{{pai[0][0],pai[0][1]}};
		// if
		// (pai1[0][0]==4&&p.getGangListType2()!=null&&p.getGangListType2().size()>0){//起手风杠
		// result.add(pai1);
		// }else if
		// (pai1[0][0]==5&&p.getGangListType2()!=null&&p.getGangListType2().size()>0){
		// result.add(pai1);
		// }
		// }
		return result.size() > 0 ? result : null;
	}

	/**
	 * 检测能不能检测椪杠
	 * 
	 * @param p
	 * @return
	 */
	private static Boolean canCheckActions(Player p) {
		Boolean result = true;
		if ((p.getGangListType1() == null || p.getGangListType1().size() == 0)
				&& (p.getGangListType2() == null || p.getGangListType2().size() == 0)
				&& (p.getCurrentMjList().size() == 4 || p.getCurrentMjList()
						.size() == 5)) {
			if (p.getChiList() != null && p.getChiList().size() > 0) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * 碰杠检测的核心方法 在传入pai参数的情况下，检测碰或者杠的逻辑基本相符（杠是四张牌的基本杠），提取出的公共方法
	 * 
	 * @param palyerPai
	 * @param pai
	 * @return
	 */
	private static List<Integer[][]> pengGangCheck(List<Integer[][]> palyerPai,
			Integer[][] pai, Integer ckeckNum) {
		if (pai == null) {// 初始杠检测
			List<Integer[][]> list = new LinkedList<>();
			Set<String> set = new HashSet<>();
			for (int i = 0; i < palyerPai.size(); i++) {
				int num = 0;
				if (!set.contains(palyerPai.get(i)[0][0] + "_"
						+ palyerPai.get(i)[0][1])) {
					for (int j = 0; j < palyerPai.size(); j++) {
						if (palyerPai.get(i)[0][0]
								.equals(palyerPai.get(j)[0][0])
								&& palyerPai.get(i)[0][1].equals(palyerPai
										.get(j)[0][1])) {
							num++;
						}
					}
				}
				if (num == 4) {
					set.add(palyerPai.get(i)[0][0] + "_"
							+ palyerPai.get(i)[0][1]);
					list.add(new Integer[][] {
							{ palyerPai.get(i)[0][0], palyerPai.get(i)[0][1] },
							{ palyerPai.get(i)[0][0], palyerPai.get(i)[0][1] },
							{ palyerPai.get(i)[0][0], palyerPai.get(i)[0][1] },
							{ palyerPai.get(i)[0][0], palyerPai.get(i)[0][1] } });
				}
			}
			return list.size() > 0 ? list : null;
		} else {
			Integer[][] pai1 = new Integer[][] { { pai[0][0], pai[0][1] } };
			ckeckNum--;
			Map<String, Integer> map = new HashMap<>();// 牌---次数
			for (int i = 0; i < palyerPai.size(); i++) {
				if (pai1[0][0].equals(palyerPai.get(i)[0][0])
						&& pai1[0][1].equals(palyerPai.get(i)[0][1])) {// 与传入的牌值相同
					if (map.containsKey(pai1[0][0] + "_" + pai1[0][1])) {
						map.put(pai1[0][0] + "_" + pai1[0][1],
								map.get(pai1[0][0] + "_" + pai1[0][1]) + 1);
					} else {
						map.put(pai1[0][0] + "_" + pai1[0][1], 1);
					}
				}
			}
			if (map.containsKey(pai1[0][0] + "_" + pai1[0][1])
					&& map.get(pai1[0][0] + "_" + pai1[0][1]) >= ckeckNum) {
				List<Integer[][]> result = new ArrayList<>();
				if (ckeckNum == 3) {
					result.add(new Integer[][] { { pai1[0][0], pai1[0][1] },
							{ pai1[0][0], pai1[0][1] },
							{ pai1[0][0], pai1[0][1] } });
				} else if (ckeckNum == 2) {
					result.add(new Integer[][] { { pai1[0][0], pai1[0][1] },
							{ pai1[0][0], pai1[0][1] } });
				}
				return result;
			}
		}
		return null;
	}

	public static List<Integer[][]> initMahjongs() {
		List<Integer[][]> list = new ArrayList<>();
		for (Integer type : MahjongCons.mahjongType.keySet()) {
			for (int i = 0; i < MahjongCons.mahjongType.get(type); i++) {
				for (int j = 0; j < 4; j++) {
					list.add(new Integer[][] { { type, i + 1 } });
				}
			}
		}
		return list;
	}

	/**
	 * 洗牌 传入一副麻将，打乱顺序之后，返回麻将
	 * 
	 * @param mahjongs
	 * @return
	 */
	public static List<Integer[][]> xiPai(List<Integer[][]> mahjongs) {
		int random = 0;
		if (mahjongs != null && mahjongs.size() > 0) {
			for (int i = mahjongs.size() - 1; i >= 0; i--) {
				Integer[][] temp = mahjongs.get(i);
				random = (int) (Math.random() * i);
				mahjongs.set(i, mahjongs.get(random));
				mahjongs.set(random, temp);
			}
		}

		return mahjongs;

		// List<Integer[][]> temp = new ArrayList<>();
		// int last = mahjongs.size();
		// int random = 0;
		// int[] pai = new int[2];
		// for(int i = 0; i <mahjongs.size() ;i++){
		// random = (int)(Math.random()*last);
		// temp.add(new
		// Integer[][]{{mahjongs.get(random)[0][0],mahjongs.get(random)[0][1]}});
		// mahjongs.remove(random);
		// i--;
		// last = mahjongs.size();
		// }
		// return temp;
	}

	/**
	 * 发牌/揭牌 传入麻将列表，以及要发几张牌，返回对应的数组 如果牌数少于要求返回的张数，返回null
	 * 
	 * @param mahjongs
	 * @param num
	 * @return
	 */
	public static List<Integer[][]> faPai(List<Integer[][]> mahjongs,
			Integer num) {
		if (mahjongs.size() == 0) {
			return null;
		}
		List<Integer[][]> result = new ArrayList<>();
		// int random = 0;
		for (int i = 0; i < num; i++) {
			// random = (int)(Math.random()*mahjongs.size());
			result.add(new Integer[][] { { mahjongs.get(i)[0][0],
					mahjongs.get(i)[0][1] } });
			mahjongs.remove(i);
		}
		if (num > 1) {
			result = paiXu(result);
		}
		return result;
	}

	/**
	 * 吃牌动作，传入玩家手上的牌，以及要吃的三张牌，返回吃牌后玩家的手上的牌
	 * 
	 * @param playerPais
	 * @param chiPais
	 * @return
	 */
	public static List<Integer[][]> chi(List<Integer[][]> playerPais,
			List<Integer[][]> chiPais) {
		if (playerPais.size() <= chiPais.size()) {
			return playerPais;
		}
		for (int i = 0; i < chiPais.size(); i++) {
			for (int j = 0; j < playerPais.size(); j++) {
				if (playerPais.get(j)[0][0].equals(chiPais.get(i)[0][0])
						&& playerPais.get(j)[0][1].equals(chiPais.get(i)[0][1])) {
					playerPais.remove(j);
					break;
				}
			}
		}
		return playerPais;
	}

	/**
	 * 碰牌操作，传入玩家手中的牌，以及要碰的牌，返回碰之后的牌
	 * 
	 * @param playerPais
	 * @param pai
	 * @return
	 */
	public static List<Integer[][]> peng(List<Integer[][]> playerPais,
			Integer[][] pai) {
		return pengOrGang(playerPais, pai, 2);
	}

	/**
	 * 杠牌操作，传入玩家手中的牌，以及要杠的牌，返回杠的类型 如果返回0，代表有玩家能有胡的操作
	 * 
	 * @param p
	 * @param pais
	 * @return
	 */
	public static Integer gang(Player p, List<Integer[][]> pais) {
		// 1特殊杠（第一手的中发白）,2特殊杠（东南西北），3碰的杠（明杠），4点的杠（明杠），5暗杠
		Integer gangType = null;
		if (pais.size() == 3) {// 1初始中发白
			Integer[][] toRemove = null;
			if ((p.getZhuaPaiNum() <= 1 || p.getChuPaiNum().equals(0))
					&& !pais.get(0)[0][1].equals(pais.get(1)[0][1])) {
				gangType = 1;
				if (p.getLastFaPai() != null
						&& p.getLastFaPai()[0][0].equals(5)) {
					for (Integer[][] temp : pais) {
						if (temp[0][1].equals(p.getLastFaPai()[0][1])) {
							toRemove = temp;
							pais.remove(temp);
							break;
						}
					}
				}
				removePais(p.getCurrentMjList(), pais);
				if (toRemove != null) {
					p.setLastFaPai(null);
					pais.add(toRemove);
					pais = paiXu(pais);
				}
			} else {
				gangType = 4;
				p.setCurrentMjList(pengOrGang(p.getCurrentMjList(),
						pais.get(0), 3));
			}
		} else if (pais.size() == 4) {//
			if (pais.get(0)[0][1].equals(pais.get(1)[0][1])) {// 5
				gangType = 5;
				if (p.getLastFaPai() != null
						&& p.getLastFaPai()[0][0].equals(pais.get(0)[0][0])
						&& p.getLastFaPai()[0][1].equals(pais.get(0)[0][1])) {
					p.setLastFaPai(null);
				}
				p.setCurrentMjList(pengOrGang(p.getCurrentMjList(),
						pais.get(0), 4));
			} else {// 2
				gangType = 2;
				Integer[][] toRemove = null;
				if (p.getLastFaPai() != null
						&& p.getLastFaPai()[0][0].equals(4)) {
					for (Integer[][] temp : pais) {
						if (temp[0][1].equals(p.getLastFaPai()[0][1])) {
							toRemove = temp;
							pais.remove(temp);
							break;
						}
					}
				}
				removePais(p.getCurrentMjList(), pais);
				if (toRemove != null) {
					p.setLastFaPai(null);
					pais.add(toRemove);
					pais = paiXu(pais);
				}
			}
		} else if (pais.size() == 1) {// 游戏中的杠或者补得中发白东南西北杠
			// 需要在过杠的时候，检测其他玩家能不能胡这张牌，
			// 检测的时候，需要注意点过的人

			if (pais.get(0)[0][0].equals(4) && p.getGangListType2() != null
					&& p.getGangListType2().size() > 0) {
				gangType = 2;
				Integer[][] toRemove = null;
				if (p.getLastFaPai() != null
						&& p.getLastFaPai()[0][0].equals(4)) {
					for (Integer[][] temp : pais) {
						if (temp[0][1].equals(p.getLastFaPai()[0][1])) {
							toRemove = temp;
							pais.remove(temp);
							break;
						}
					}
				}
				removePais(p.getCurrentMjList(), pais);
				if (toRemove != null) {
					p.setLastFaPai(null);
					pais.add(toRemove);
					pais = paiXu(pais);
				}
			} else if (pais.get(0)[0][0].equals(5)
					&& p.getGangListType1() != null
					&& p.getGangListType1().size() > 0) {
				gangType = 1;
				Integer[][] toRemove = null;
				if (p.getLastFaPai() != null
						&& p.getLastFaPai()[0][0].equals(5)) {
					for (Integer[][] temp : pais) {
						if (temp[0][1].equals(p.getLastFaPai()[0][1])) {
							toRemove = temp;
							pais.remove(temp);
							break;
						}
					}
				}
				removePais(p.getCurrentMjList(), pais);
				if (toRemove != null) {
					p.setLastFaPai(null);
					pais.add(toRemove);
					pais = paiXu(pais);
				}
			} else {
				Integer[][] pai = pais.get(0);
				if (p.getPengList() != null && p.getPengList().size() > 0) {
					boolean flag = false;// 是不是碰的杠3
					for (int i = 0; i < p.getPengList().size(); i++) {
						List<Integer[][]> pengList = p.getPengList().get(i)
								.getL();
						if (pengList.get(0)[0][0].equals(pai[0][0])
								&& pengList.get(0)[0][1].equals(pai[0][1])) {
							gangType = 3;
							flag = true;
							if (p.getLastFaPai() != null) {
								if (pai[0][0].equals(p.getLastFaPai()[0][0])
										&& pai[0][1]
												.equals(p.getLastFaPai()[0][1])) {// 移除随后发的牌
									p.setLastFaPai(null);
								} else {// 需要把最后发的牌加入手牌
									p.getCurrentMjList().add(
											new Integer[][] { {
													p.getLastFaPai()[0][0],
													p.getLastFaPai()[0][1] } });
									p.setLastFaPai(null);
									// 移除手牌
									pengOrGang(p.getCurrentMjList(), pai, 1);
								}
							} else {
								// 移除手牌
								pengOrGang(p.getCurrentMjList(), pai, 1);
							}
							p.getGangListType3().add(p.getPengList().get(i));
							p.getPengList().remove(i);
							p.getGangListType3()
									.get(p.getGangListType3().size() - 1)
									.getL()
									.add(new Integer[][] { { pai[0][0],
											pai[0][1] } });
							break;
						}
					}
					if (!flag) {// 4点杠
						gangType = 4;
						p.setCurrentMjList(pengOrGang(p.getCurrentMjList(),
								pais.get(0), 3));
					}
				} else {// 4点杠
					gangType = 4;
					p.setCurrentMjList(pengOrGang(p.getCurrentMjList(),
							pais.get(0), 3));
				}
			}
		}
		return gangType;
	}

	private static void removePais(List<Integer[][]> playerPais,
			List<Integer[][]> toRemovePais) {
		for (int i = 0; i < toRemovePais.size(); i++) {
			for (int j = 0; j < playerPais.size(); j++) {
				if (playerPais.get(j)[0][0].equals(toRemovePais.get(i)[0][0])
						&& playerPais.get(j)[0][1]
								.equals(toRemovePais.get(i)[0][1])) {
					playerPais.remove(j);
					break;
				}
			}
		}
	}

	/**
	 * 碰杠的执行方法
	 * 
	 * @param playerPais
	 * @param pai
	 * @param num
	 * @return
	 */
	private static List<Integer[][]> pengOrGang(List<Integer[][]> playerPais,
			Integer[][] pai, Integer num) {
		for (int n = 0; n < num; n++) {
			for (int i = 0; i < playerPais.size(); i++) {
				if (pai[0][0].equals(playerPais.get(i)[0][0])
						&& pai[0][1].equals(playerPais.get(i)[0][1])) {
					playerPais.remove(i);
					break;
				}
			}
		}
		return playerPais;
	}

	/**
	 * 胡牌类型检测 胡牌时，pai已经加入玩家手牌了
	 */
	public static String checkHuInfo(Player winUser, Player toUser,
			Integer[][] pai) {
		StringBuffer sb = new StringBuffer();
		if (winUser.getUserId().equals(toUser.getUserId())) {// 自摸
			sb.append(Cnst.HU_FAN_ZI_MO);
		}
		Boolean menqing = isMenQing(winUser);
		if (menqing) {
			sb.append(Cnst.HU_FAN_MEN_QING);
		}
		List<Player> players = TCPGameFunctions.getPlayerList(winUser
				.getRoomId());
		Boolean sanjiaqing = true;
		for (Player p : players) {
			if (!p.getUserId().equals(winUser.getUserId())) {
				if (!isMenQing(p)) {
					sanjiaqing = false;
					break;
				}
			}
		}
		if (sanjiaqing) {
			sb.append(Cnst.HU_FAN_SAN_JIA_QING);
		}
		if (menqing && sanjiaqing) {
			sb.append(Cnst.HU_FAN_SI_JIA_QING);
		}
		sb.append(checkHuType(winUser, winUser.getCurrentMjList(), pai));
		return sb.toString();
	}

	private static Boolean isMenQing(Player p) {
		if ((p.getChiList() == null || p.getChiList().size() == 0)
				&& (p.getPengList() == null || p.getPengList().size() == 0)
				&& (p.getGangListType3() == null || p.getGangListType3().size() == 0)
				&& (p.getGangListType4() == null || p.getGangListType4().size() == 0)) {
			return true;
		}
		return false;
	}

	private static String checkHuType(Player huUser, List<Integer[][]> paiInfo,
			Integer[][] pai) {
		Integer huType = Cnst.HUTYPE_PINGHU;
		Integer tempHuType = huType;
		List<Integer[][]> paiList = new ArrayList<>();
		for (int i = 0; i < paiInfo.size(); i++) {
			paiList.add(new Integer[][] { { paiInfo.get(i)[0][0],
					paiInfo.get(i)[0][1] } });
		}
		paiList = paiXu(paiList);
		List<Integer[][]> shunzi = new ArrayList<>();

		Set<String> duiSet = new HashSet<>();// 存放当过对牌的集合
		for (int i = 0; i < paiList.size(); i++) {
			if (checkPaiNum(paiList, paiList.get(i), 0) >= 2) {// 可能是对子
				if (!duiSet.contains(paiList.get(i)[0][0] + "_"
						+ paiList.get(i)[0][1])) {
					duiSet.add(paiList.get(i)[0][0] + "_"
							+ paiList.get(i)[0][1]);
					// 保存并移除相邻的两张
					Integer[][] iPai = paiList.get(i);
					Integer[][] iPai1 = paiList.get(i + 1);
					paiList.remove(i + 1);
					paiList.remove(i);
					if (heartCheckHu(paiList, shunzi)) {// 说明当前对子可以胡
						Boolean erBa = false;
						// 飘
						if (paiList.size() == 0
								&& (huUser.getChiList() == null || huUser
										.getChiList().size() == 0)) {
							huType = Cnst.HUTYPE_PIAO;
						} else if (paiList.size() > 0) {
							boolean flag = true;
							for (int j = 0; j < paiList.size(); j++) {
								if (checkPaiNum(paiList, paiList.get(j), 0) < 3) {
									flag = false;
									break;
								}
							}
							if (flag
									&& (huUser.getChiList() == null || huUser
											.getChiList().size() == 0)) {
								huType = Cnst.HUTYPE_PIAO;
							}
						}//
							// 28
						if (!iPai[0][0].equals(4)
								&& !iPai[0][0].equals(5)
								&& (iPai[0][1].equals(2) || iPai[0][1]
										.equals(8))) {// 28对
							erBa = true;
						}//
						if (iPai[0][0].equals(pai[0][0])
								&& iPai[0][1].equals(pai[0][1])) {// 单吊
							if (huType < Cnst.HUTYPE_DANDIAO) {
								huType = Cnst.HUTYPE_DANDIAO;
							}
						} else {
							if (shunzi != null && shunzi.size() > 0) {
								shunzi = paiXu(shunzi);
								for (int n = 0; n < shunzi.size(); n++) {
									Integer[][] p = shunzi.get(n);
									List<Integer[][]> temp = new ArrayList<>();
									temp.add(p);
									boolean f1 = false;
									boolean f2 = false;
									for (int m = n; m < shunzi.size(); m++) {
										if (shunzi.get(m)[0][0].equals(p[0][0])
												&& shunzi.get(m)[0][1]
														.equals(p[0][1] + 1)
												&& !f1) {
											f1 = true;
											temp.add(shunzi.get(m));
										}
										if (shunzi.get(m)[0][0].equals(p[0][0])
												&& shunzi.get(m)[0][1]
														.equals(p[0][1] + 2)
												&& !f2) {
											f2 = true;
											temp.add(shunzi.get(m));
										}
									}
									temp = paiXu(temp);
									if (temp.get(1)[0][0].equals(pai[0][0])
											&& temp.get(1)[0][1]
													.equals(pai[0][1])) {// 夹胡
										if (huType < Cnst.HUTYPE_JIA) {
											huType = Cnst.HUTYPE_JIA;
											break;
										}
									}
									shunzi.removeAll(temp);
									n = -1;
								}
							}
						}
						if (erBa) {
							// huType = ;
							if (Cnst.HU_FAN_SI_ER_BA * 10 + huType > tempHuType) {
								tempHuType = Cnst.HU_FAN_SI_ER_BA * 10 + huType;
							}
						} else {
							if (huType > tempHuType) {
								tempHuType = huType;
							}
						}
					} else {
						shunzi = new ArrayList<>();
					}
					paiList.add(i, iPai);
					paiList.add(i + 1, iPai1);
				}
			}
		}
		return String.valueOf(tempHuType);
	}

	private static Boolean heartCheckHu(List<Integer[][]> playerPais,
			List<Integer[][]> shunzi) {
		List<Integer[][]> currentList = new ArrayList<>();
		currentList.addAll(playerPais);

		for (int j = 0; j < currentList.size(); j++) {
			Integer num = checkPaiNum(currentList, currentList.get(j), j);// 可以看成是顺子的个数
			if (num < 3) {
				if (checkShunZi(currentList, j, num)) {
					// 移除已经组成的顺子，然后递归
					return heartCheckHu(
							removeShunZi(currentList, currentList.get(j), num,
									shunzi), shunzi);
				} else {
					return false;
				}
			} else {
				Integer[][] iPai = currentList.get(j);
				Integer[][] iPai1 = currentList.get(j + 1);
				Integer[][] iPai2 = currentList.get(j + 2);
				currentList.remove(j + 2);
				currentList.remove(j + 1);
				currentList.remove(j);
				if (heartCheckHu(currentList, shunzi)) {// 按照暗刻来计算胡牌
					return true;
				} else {// 按照三个顺子来计算胡牌
					currentList.add(j, iPai);
					currentList.add(j + 1, iPai1);
					currentList.add(j + 2, iPai2);
					if (checkShunZi(currentList, j, num)) {
						return heartCheckHu(
								removeShunZi(currentList, currentList.get(j),
										num, shunzi), shunzi);
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * 胡牌检测--移除顺子部分 把可以组成顺子的移除掉，返回移除后的list
	 * 
	 * @param playerPais
	 * @param pai
	 * @param num
	 * @return
	 */
	private static List<Integer[][]> removeShunZi(List<Integer[][]> playerPais,
			Integer[][] pai, Integer num, List<Integer[][]> shunzi) {
		int fn = 0, sn = 0, tn = 0;
		for (int k = 0; k < playerPais.size(); k++) {
			if (fn < num && pai[0][0].equals(playerPais.get(k)[0][0])
					&& pai[0][1].equals(playerPais.get(k)[0][1])) {
				fn++;
				shunzi.add(playerPais.get(k));
				playerPais.remove(k--);
			} else if (sn < num && pai[0][0].equals(playerPais.get(k)[0][0])
					&& playerPais.get(k)[0][1].equals(pai[0][1] + 1)) {
				sn++;
				shunzi.add(playerPais.get(k));
				playerPais.remove(k--);
			} else if (tn < num && pai[0][0].equals(playerPais.get(k)[0][0])
					&& playerPais.get(k)[0][1].equals(pai[0][1] + 2)) {
				tn++;
				shunzi.add(playerPais.get(k));
				playerPais.remove(k--);
			}
		}
		return playerPais;
	}
}
