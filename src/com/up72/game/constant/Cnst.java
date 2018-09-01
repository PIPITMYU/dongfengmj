package com.up72.game.constant;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import com.up72.game.utils.ProjectInfoPropertyUtil;

/**
 * 常量
 */
public class Cnst {
	
	// 获取项目版本信息
    public static final String version = ProjectInfoPropertyUtil.getProperty("project_version", "1.5");
    public static final String cid = ProjectInfoPropertyUtil.getProperty("cid", "1");
    
    public static Boolean isTest = true;//是否是测试环境
    
    //回放文件目录
    public static final String BACK_FILE_PATH = ProjectInfoPropertyUtil.getProperty("backFilePath", "1.5");
    public static final String HTTP_URL = ProjectInfoPropertyUtil.getProperty("httpUrl", "1.5");
    public static final String FILE_ROOT_PATH = ProjectInfoPropertyUtil.getProperty("fileRootPath", "1.5");

    public static final String p_name = ProjectInfoPropertyUtil.getProperty("p_name", "wsw_X1");
    public static final String o_name = ProjectInfoPropertyUtil.getProperty("o_name", "u_consume");
    public static final String gm_url = ProjectInfoPropertyUtil.getProperty("gm_url", "");
    
    //redis配置
    public static final String REDIS_HOST = ProjectInfoPropertyUtil.getProperty("redis.host", "");
    public static final String REDIS_PORT = ProjectInfoPropertyUtil.getProperty("redis.port", "");
    public static final String REDIS_PASSWORD = ProjectInfoPropertyUtil.getProperty("redis.password", "");

    //mina的端口
    public static final String MINA_PORT = ProjectInfoPropertyUtil.getProperty("mina.port", "");
    
    public static String SERVER_IP = getLocalAddress();
    public static String getLocalAddress(){
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ip;
	}
    
    
    
    public static final long HEART_TIME = 10000;
    
    public static final long ROOM_OVER_TIME = 5*60*60*1000;//房间定时24小时解散
    public static final long ROOM_CREATE_DIS_TIME = 40*60*1000;//创建房间之后，40分钟解散
    public static final long ROOM_DIS_TIME = 5*60*1000;//玩家发起解散房间之后，5分钟自动解散
    public static final String CLEAN_3 = "0 0 3 * * ?";
    public static final String CLEAN_EVERY_HOUR = "0 0 0/1 * * ?";
    public static final String COUNT_EVERY_TEN_MINUTE = "0 0/1 * * * ?";
    public static final long BACKFILE_STORE_TIME = 3*24*60*60*1000;//回放文件保存时间
    public static final int MONEY_INIT = 12;//初始赠送给用户的房卡数

    
    //测试时间
//    public static final long ROOM_OVER_TIME = 60*1000;//
//    public static final long ROOM_CREATE_DIS_TIME = 20*1000;
//    public static final long ROOM_DIS_TIME = 10*1000;
//	public static final String CLEAN_3 = "0/1 * * * * ?";
//	public static final String CLEAN_EVERY_HOUR = "0/1 * * * * ?";
//  public static final String COUNT_EVERY_TEN_MINUTE = "0/1 * * * * ?";
//    public static final long BACKFILE_STORE_TIME = 60*1000;//回放文件保存时间
    
    public static final int DIS_ROOM_RESULT = 1;

    public static final int DIS_ROOM_TYPE_1 = 1;//创建房间40分钟解散类型
    public static final int DIS_ROOM_TYPE_2 = 2;//玩家点击解散房间类型

    public static final int PAGE_SIZE = 10;

    //风向表示
    public static final int WIND_EAST = 1;
    public static final int WIND_SOUTH = 2;
    public static final int WIND_WEST = 3;
    public static final int WIND_NORTH = 4;

    public static final String USER_SESSION_USER_ID = "user_id";
    public static final String USER_SESSION_IP = "ip";

    //房间状态
    // 1等待玩家入坐；2游戏中；3小结算
    public static final int ROOM_STATE_CREATED = 1;
    public static final int ROOM_STATE_GAMIING = 2;
    public static final int ROOM_STATE_XJS = 3;
    public static final int ROOM_STATE_YJS = 4;

    //房间类型
    public static final int ROOM_TYPE_1 = 1;//房主模式
    public static final int ROOM_TYPE_2 = 2;//自由模式


    //小局结算时的
    public static final int OVER_TYPE_1 = 1;//胜利
    public static final int OVER_TYPE_2 = 2;//失败
    public static final int OVER_TYPE_3 = 3;//荒庄


    //开房的局数对应消耗的房卡数
    public static final Map<Integer,Integer> moneyMap = new HashMap<>();
    static {
        moneyMap.put(2,4);
        moneyMap.put(4,8);
        moneyMap.put(8,16);
    }

    //玩家在线状态
    public static final String PLAYER_LINE_STATE_INLINE = "inline";
    public static final String PLAYER_LINE_STATE_OUT = "out";

    //玩家状态
    public static final String PLAYER_STATE_DATING = "dating";
    public static final String PLAYER_STATE_IN = "in";
    public static final String PLAYER_STATE_PREPARED = "prepared";
    public static final String PLAYER_STATE_CHU = "chu";
    public static final String PLAYER_STATE_WAIT = "wait";
    public static final String PLAYER_STATE_XJS = "xjs";

    //请求状态
    public static final int REQ_STATE_0 = 0;//非法请求
    public static final int REQ_STATE_1 = 1;//正常
    public static final int REQ_STATE_2 = 2;//余额不足
    public static final int REQ_STATE_3 = 3;//已经在其他房间中
    public static final int REQ_STATE_4 = 4;//房间不存在
    public static final int REQ_STATE_5 = 5;//房间人员已满
    public static final int REQ_STATE_6 = 6;//游戏中，不能退出房间
    public static final int REQ_STATE_7 = 7;//有玩家拒绝解散房间
    public static final int REQ_STATE_8 = 8;//玩家不存在（代开模式中，房主踢人用的）
    public static final int REQ_STATE_9 = 9;//接口id不符合，需请求大接口
    public static final int REQ_STATE_10 = 10;//代开房间创建成功
    public static final int REQ_STATE_11 = 11;//已经代开过10个了，不能再代开了
    public static final int REQ_STATE_12 = 12;//房间存在超过24小时解散的提示
    public static final int REQ_STATE_13 = 13;//房间40分钟未开局解散提示
    public static final int REQ_STATE_14 = 14;//ip不一致

    //动作列表
    public static final int ACTION_HU = 4;
    public static final int ACTION_GANG = 3;
    public static final int ACTION_PENG = 2;
    public static final int ACTION_CHI = 1;
    public static final int ACTION_GUO = 0;

    //牌局底分
    public static final int SCORE_BASE = 1;


    //胡牌类型
    public static final int HUTYPE_PINGHU = 1;
    public static final int HUTYPE_JIA = 2;
    public static final int HUTYPE_DANDIAO = 3;
    public static final int HUTYPE_PIAO = 4;//飘胡的分数按照房间的封顶分计算

    public static final int MAX_SCORE_20 = 20;
    public static final int MAX_SCORE_40 = 40;

    public static final Map<Integer,Integer> huScore = new HashMap<>();
    static {
        huScore.put(1,1);
        huScore.put(2,2);
        huScore.put(3,2);
    }
    //胡牌番的类型
    public static final int HU_FAN_ZI_MO = 1;
    public static final int HU_FAN_MEN_QING = 2;
    public static final int HU_FAN_SAN_JIA_QING = 3;
    public static final int HU_FAN_SI_JIA_QING = 4;
    public static final int HU_FAN_SI_ER_BA = 5;



    //杠分数计算
    public static final int GANG_TYPE_SPECIAL = 2;
    public static final int GANG_TYPE_MING = 2;
    public static final int GANG_TYPE_MING_DUBBOL = 4;
    public static final int GANG_TYPE_AN = 4;
    public static final int GANG_TYPE_AN_DUBBOL = 8;

    //退出类型
    public static final String EXIST_TYPE_EXIST = "exist";
    public static final String EXIST_TYPE_DISSOLVE = "dissolve";
    
    
    
    //redis存储的key的不同类型的前缀
    public static final String REDIS_PREFIX_ROOMMAP = "DONGFENG_ROOM_MAP_";//房间信息
//    public static final String REDIS_PREFIX_USERROOMNUMBERMAP = "USER_ROOMNUM_MAP_";//用户房间号码信息
//    public static final String REDIS_PREFIX_ROOMUSERMAP = "ROOM_USERS_MAP_";//房间人员信息
//    public static final String REDIS_PREFIX_IOSESSIONMAP = "IOSESSION_MAP_";//玩家——session数据
    public static final String REDIS_PREFIX_OPENIDUSERMAP = "DONGFENG_OPENID_USERID_MAP_";//openId-user数据
    
//    public static final String REDIS_PREFIX_DISROOMIDMAP = "DIS_ROOMID_MAP_";//解散房间的任务
//    public static final String REDIS_PREFIX_DISROOMIDRESULTINFO = "DIS_ROOM_RESULT_MAP_";//房间解散状态集合
    
    public static final String REDIS_PREFIX_USER_ID_USER_MAP = "DONGFENG_USER_ID_USER_MAP_";//通过userId获取用户
    
    //redis中通知的key
    public static final String NOTICE_KEY = "DONGFENG_NOTICE_KEY";
    
    public static final String REDIS_ONLINE_NUM_COUNT = "DONGFENG_ONLINE_NUM_";
    
    public static final String PROJECT_PREFIX = "DONGFENG_*";
    
    public static final String REDIS_PREFIX_CLUBMAP = "DONGFENG_CLUB_MAP_";//东风俱乐部信息
    public static final String REDIS_PREFIX_CLUBMAP_LIST = "DONGFENG_CLUB_MAP_LIST_";//存放俱乐部未开局房间信息
    //俱乐部的局数对应消耗的房卡数
    public static final Map<Integer,Integer> clubMoneyMap = new HashMap<>();
    static {
        clubMoneyMap.put(2,4);
        clubMoneyMap.put(4,8);
        clubMoneyMap.put(8,16);
    }
    
    public static final String REDIS_PAY_ORDERNUM = "DONGFENG_PAY_ORDERNUM";//充值订单号
    
    
}
