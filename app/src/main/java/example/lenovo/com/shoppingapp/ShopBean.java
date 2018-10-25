package example.lenovo.com.shoppingapp;

import java.util.List;

/**
 * author：shashe
 * 日期：2018/10/24
 */
public class ShopBean {
    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"bargainPrice":99,"createtime":"2017-10-14T21:38:26","detailUrl":"https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg","num":14,"pid":45,"price":2999,"pscid":39,"selected":0,"sellerid":1,"subhead":"高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！","title":"一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机"},{"bargainPrice":11800,"createtime":"2017-10-10T17:33:37","detailUrl":"https://item.m.jd.com/product/4338107.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t6700/155/2098998076/156185/6cf95035/595dd5a5Nc3a7dab5.jpg!q70.jpg","num":30,"pid":57,"price":5199,"pscid":40,"selected":0,"sellerid":1,"subhead":"【i5 MX150 2G显存】全高清窄边框 8G内存 256固态硬盘 支持指纹识别 预装WIN10系统","title":"小米(MI)Air 13.3英寸全金属轻薄笔记本(i5-7200U 8G 256G PCle SSD MX150 2G独显 FHD 指纹识别 Win10）银\r\n"},{"bargainPrice":111.99,"createtime":"2017-10-03T23:53:28","detailUrl":"https://item.m.jd.com/product/4719303.html?utm_source=androidapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=QQfriends","images":"https://m.360buyimg.com/n0/jfs/t9004/210/1160833155/647627/ad6be059/59b4f4e1N9a2b1532.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7504/338/63721388/491286/f5957f53/598e95f1N7f2adb87.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t7441/10/64242474/419246/adb30a7d/598e95fbNd989ba0a.jpg!q70.jpg","num":1,"pid":8,"price":324,"pscid":1,"selected":0,"sellerid":1,"subhead":"每个中秋都不能简单，无论身在何处，你总需要一块饼让生活更圆满，京东月饼让爱更圆满京东自营，闪电配送，更多惊喜，快用手指戳一下","title":"北京稻香村 稻香村中秋节月饼 老北京月饼礼盒655g"}]
         * sellerName : 商家1
         * sellerid : 1
         */

        private String sellerName;
        private String sellerid;
        private List<ListBean> list;

        public String getSellerName() {
            return sellerName;
        }

        public void setSellerName(String sellerName) {
            this.sellerName = sellerName;
        }

        public String getSellerid() {
            return sellerid;
        }

        public void setSellerid(String sellerid) {
            this.sellerid = sellerid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * bargainPrice : 99
             * createtime : 2017-10-14T21:38:26
             * detailUrl : https://item.m.jd.com/product/4345173.html?utm#_source=androidapp&utm#_medium=appshare&utm#_campaign=t#_335139774&utm#_term=QQfriends
             * images : https://m.360buyimg.com/n0/jfs/t6037/35/2944615848/95178/6cd6cff0/594a3a10Na4ec7f39.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6607/258/1025744923/75738/da120a2d/594a3a12Ne3e6bc56.jpg!q70.jpg|https://m.360buyimg.com/n0/jfs/t6370/292/1057025420/64655/f87644e3/594a3a12N5b900606.jpg!q70.jpg
             * num : 14
             * pid : 45
             * price : 2999
             * pscid : 39
             * selected : 0
             * sellerid : 1
             * subhead : 高清双摄，就是清晰！2000+1600万高清摄像头，6GB大内存+高通骁龙835处理器，性能怪兽！
             * title : 一加手机5 (A5000) 6GB+64GB 月岩灰 全网通 双卡双待 移动联通电信4G手机
             */

            private double bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int num;
            private int pid;
            private double price;
            private int pscid;
            private int selected;
            private int sellerid;
            private String subhead;
            private String title;

            private boolean isCheck;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            public double getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(double bargainPrice) {
                this.bargainPrice = bargainPrice;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getDetailUrl() {
                return detailUrl;
            }

            public void setDetailUrl(String detailUrl) {
                this.detailUrl = detailUrl;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSelected() {
                return selected;
            }

            public void setSelected(int selected) {
                this.selected = selected;
            }

            public int getSellerid() {
                return sellerid;
            }

            public void setSellerid(int sellerid) {
                this.sellerid = sellerid;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
