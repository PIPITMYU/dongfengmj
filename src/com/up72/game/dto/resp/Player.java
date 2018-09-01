package com.up72.game.dto.resp;

import com.up72.game.model.User;
import com.up72.server.mina.bean.InfoCount;
import com.up72.server.mina.function.TCPGameFunctions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/6/26.
 */
public class Player extends User {

    private Integer roomId;//房间密码，也是roomSn

    // out离开状态（断线）;inline正常在线；
    private String status;
    private List<Integer[][]> currentMjList;//用户手中当前的牌
    private List<InfoCount> chiList;//吃的集合，每个list元素是三行两列
    private List<InfoCount> pengList;//碰的集合，每个list元素是一行两列
    //1特殊杠（第一手的中发白）,2特殊杠（东南西北），3碰的杠（明杠），4点的杠（明杠），5暗杠
    private List<InfoCount> gangListType1;//杠的集合，每个list元素是一行两列
    private List<InfoCount> gangListType2;//杠的集合，每个list元素是一行两列
    private List<InfoCount> gangListType3;//杠的集合，每个list元素是一行两列
    private List<InfoCount> gangListType4;//杠的集合，每个list元素是一行两列
    private List<InfoCount> gangListType5;//杠的集合，每个list元素是一行两列
    private List<Integer[][]> tingList;//听牌后胡牌集合，每个list元素是一行两列
    private List<Integer[][]> chuList;//出牌的集合，每个list元素是一行两列
    private Integer position;//位置信息；详见Cnst
    private Boolean zhuang;//是否是庄家
    private String ip;
    private Map<String,Object> currentActions;//玩家当前的动作，01234对应 过吃碰杠胡；已排序
    private Boolean isHu;
    private Integer huType;//胡牌类型，1平胡，2点炮；3流局
    private Boolean isDian;
    private Integer score;//玩家积分；初始为1000，待定
    private String notice;//跑马灯信息
    //用户当前状态，
    // dating用户在大厅中;
    // in刚进入房间，等待状态;
    // prepared准备状态;
    // chu出牌状态（该出牌了）;
    // wait等待状态（非出牌状态）
    private String playStatus;

    private Integer zhuaPaiNum;//抓牌的张数
    private Integer chuPaiNum;//出牌的张数

    private String cid;

    private Integer huNum;//胡的次数
    private Integer loseNum;//输的此时
    private Integer[][] lastFaPai;//上次发的牌
    
    private Long lastHeartTimeLong;//上次心跳时间
    private Integer dianNum;//点炮次数
    private Integer zhuangNum;//坐庄次数
    private Integer zimoNum;//自摸次数
    
    private Integer joinIndex;//加入顺序
    
    private Boolean needFaPai;
    
    private Long sessionId;
    
    public void initPlayer(Integer roomId,Integer position,Boolean zhuang,String playStatus,Integer score,Integer huNum,Integer loseNum){
    	//用户回到大厅
    	if (roomId==null) {
        	this.dianNum = 0;
        	this.zhuangNum = 0;
        	this.zimoNum = 0;
        	this.joinIndex = null;
		}
    	this.roomId = roomId;

    	this.currentMjList = null;
    	this.chiList = new ArrayList<>();
    	this.pengList = new ArrayList<>();
    	this.gangListType1 = new ArrayList<>();
    	this.gangListType2 = new ArrayList<>();
    	this.gangListType3 = new ArrayList<>();
    	this.gangListType4 = new ArrayList<>();
    	this.gangListType5 = new ArrayList<>();
    	this.tingList = null;
    	this.chuList = new ArrayList<>();
    	this.position = position;
    	this.zhuang = zhuang;

    	this.currentActions = null;
    	this.isHu = false;
    	this.huType = null;
    	this.isDian = false;
    	this.score = score;

    	this.playStatus = playStatus;
    	this.zhuaPaiNum = 0;
    	this.chuPaiNum = 0;

    	this.huNum = huNum;
    	this.loseNum = loseNum;
    	this.lastFaPai = null;
    	this.needFaPai = false;
    }
    

	public Long getSessionId() {
		return sessionId;
	}



	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}



	public Boolean getNeedFaPai() {
		return needFaPai;
	}



	public void setNeedFaPai(Boolean needFaPai) {
		this.needFaPai = needFaPai;
	}



	public Integer getJoinIndex() {
		return joinIndex;
	}



	public void setJoinIndex(Integer joinIndex) {
		this.joinIndex = joinIndex;
	}



	public Long getLastHeartTimeLong() {
		return lastHeartTimeLong;
	}


	public void setLastHeartTimeLong(Long lastHeartTimeLong) {
		this.lastHeartTimeLong = lastHeartTimeLong;
	}


	public Boolean getIsHu() {
		return isHu;
	}


	public void setIsHu(Boolean isHu) {
		this.isHu = isHu;
	}


	public Boolean getIsDian() {
		return isDian;
	}


	public void setIsDian(Boolean isDian) {
		this.isDian = isDian;
	}


	public Integer getChuPaiNum() {
		return chuPaiNum;
	}


	public void setChuPaiNum(Integer chuPaiNum) {
		this.chuPaiNum = chuPaiNum;
	}


	public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer[][]> getCurrentMjList() {
        return currentMjList;
    }

    public void setCurrentMjList(List<Integer[][]> currentMjList) {
        this.currentMjList = currentMjList;
    }

    public List<InfoCount> getChiList() {
        return chiList;
    }

    public void setChiList(List<InfoCount> chiList) {
        this.chiList = chiList;
    }

    public List<InfoCount> getPengList() {
        return pengList;
    }

    public void setPengList(List<InfoCount> pengList) {
        this.pengList = pengList;
    }

    public List<Integer[][]> getTingList() {
        return tingList;
    }

    public void setTingList(List<Integer[][]> tingList) {
        this.tingList = tingList;
    }

    public List<Integer[][]> getChuList() {
        return chuList;
    }

    public void setChuList(List<Integer[][]> chuList) {
        this.chuList = chuList;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Boolean getZhuang() {
        return zhuang;
    }

    public void setZhuang(Boolean zhuang) {
        this.zhuang = zhuang;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Map<String, Object> getCurrentActions() {
        return currentActions;
    }

    public void setCurrentActions(Map<String, Object> currentActions) {
        this.currentActions = currentActions;
    }


    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
    }

    public Integer getHuType() {
        return huType;
    }

    public void setHuType(Integer huType) {
        this.huType = huType;
    }

    public Integer getZhuaPaiNum() {
        return zhuaPaiNum;
    }

    public void setZhuaPaiNum(Integer zhuaPaiNum) {
        this.zhuaPaiNum = zhuaPaiNum;
    }

    public List<InfoCount> getGangListType1() {
        return gangListType1;
    }

    public void setGangListType1(List<InfoCount> gangListType1) {
        this.gangListType1 = gangListType1;
    }

    public List<InfoCount> getGangListType2() {
        return gangListType2;
    }

    public void setGangListType2(List<InfoCount> gangListType2) {
        this.gangListType2 = gangListType2;
    }

    public List<InfoCount> getGangListType3() {
        return gangListType3;
    }

    public void setGangListType3(List<InfoCount> gangListType3) {
        this.gangListType3 = gangListType3;
    }

    public List<InfoCount> getGangListType4() {
        return gangListType4;
    }

    public void setGangListType4(List<InfoCount> gangListType4) {
        this.gangListType4 = gangListType4;
    }

    public List<InfoCount> getGangListType5() {
        return gangListType5;
    }

    public void setGangListType5(List<InfoCount> gangListType5) {
        this.gangListType5 = gangListType5;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getHuNum() {
        return huNum;
    }

    public void setHuNum(Integer huNum) {
        this.huNum = huNum;
    }

    public Integer getLoseNum() {
        return loseNum;
    }

    public void setLoseNum(Integer loseNum) {
        this.loseNum = loseNum;
    }

    public Integer[][] getLastFaPai() {
        return lastFaPai;
    }

    public void setLastFaPai(Integer[][] lastFaPai) {
        this.lastFaPai = lastFaPai;
    }


	public Integer getDianNum() {
		return dianNum;
	}


	public void setDianNum(Integer dianNum) {
		this.dianNum = dianNum;
	}


	public Integer getZhuangNum() {
		return zhuangNum;
	}


	public void setZhuangNum(Integer zhuangNum) {
		this.zhuangNum = zhuangNum;
	}


	public Integer getZimoNum() {
		return zimoNum;
	}


	public void setZimoNum(Integer zimoNum) {
		this.zimoNum = zimoNum;
	}
    
    
}
