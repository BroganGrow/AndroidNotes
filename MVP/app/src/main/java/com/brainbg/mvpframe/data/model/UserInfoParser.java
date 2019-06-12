package com.brainbg.mvpframe.data.model;

import java.util.List;

/**
 * <pre>
 *     author : Brainbg
 *     e-mail : xxx@xx
 *     time   : 2019/05/14
 *     desc   :
 * </pre>
 */
public class UserInfoParser {

    /**
     * ret : 200
     * data : {"code":0,"msg":"success","info":{"integral":15,"avatar":"http://img.pgstc.68bing.com/116c517b97a1462413625ec65364488f.avator","nickname":"Brainbg白雨","username":"","money":"0.00","mobile":"15118145721","birthday":"1993-12-27","gender":"男","coupons":0,"customer_service_tel":"021-88888888","common_user_center_notice":"用户中心公告文字，后台配置修改。","user_order_status":[{"name":"待确认","status":0,"count":0},{"name":"待付款","status":1,"count":0},{"name":"待发货","status":2,"count":0},{"name":"待收货","status":3,"count":0},{"name":"已完成","status":4,"count":0},{"name":"已取消","status":5,"count":0},{"name":"已关闭","status":6,"count":0},{"name":"待评价","status":100,"count":0}],"user_order_count":0,"user_goods_favor_count":0,"user_goods_browse_count":0,"common_message_total":3,"common_app_is_enable_answer":1}}
     * msg :
     */

    private int ret;
    private DataBean data;
    private String msg;

    @Override
    public String toString() {
        return "UserInfoParser{" +
                "ret=" + ret +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        /**
         * code : 0
         * msg : success
         * info : {"integral":15,"avatar":"http://img.pgstc.68bing.com/116c517b97a1462413625ec65364488f.avator","nickname":"Brainbg白雨","username":"","money":"0.00","mobile":"15118145721","birthday":"1993-12-27","gender":"男","coupons":0,"customer_service_tel":"021-88888888","common_user_center_notice":"用户中心公告文字，后台配置修改。","user_order_status":[{"name":"待确认","status":0,"count":0},{"name":"待付款","status":1,"count":0},{"name":"待发货","status":2,"count":0},{"name":"待收货","status":3,"count":0},{"name":"已完成","status":4,"count":0},{"name":"已取消","status":5,"count":0},{"name":"已关闭","status":6,"count":0},{"name":"待评价","status":100,"count":0}],"user_order_count":0,"user_goods_favor_count":0,"user_goods_browse_count":0,"common_message_total":3,"common_app_is_enable_answer":1}
         */

        private int code;
        private String msg;
        private InfoBean info;

        @Override
        public String toString() {
            return "DataBean{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    ", info=" + info +
                    '}';
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * integral : 15
             * avatar : http://img.pgstc.68bing.com/116c517b97a1462413625ec65364488f.avator
             * nickname : Brainbg白雨
             * username :
             * money : 0.00
             * mobile : 15118145721
             * birthday : 1993-12-27
             * gender : 男
             * coupons : 0
             * customer_service_tel : 021-88888888
             * common_user_center_notice : 用户中心公告文字，后台配置修改。
             * user_order_status : [{"name":"待确认","status":0,"count":0},{"name":"待付款","status":1,"count":0},{"name":"待发货","status":2,"count":0},{"name":"待收货","status":3,"count":0},{"name":"已完成","status":4,"count":0},{"name":"已取消","status":5,"count":0},{"name":"已关闭","status":6,"count":0},{"name":"待评价","status":100,"count":0}]
             * user_order_count : 0
             * user_goods_favor_count : 0
             * user_goods_browse_count : 0
             * common_message_total : 3
             * common_app_is_enable_answer : 1
             */

            private int integral;
            private String avatar;
            private String nickname;
            private String username;
            private String money;
            private String mobile;
            private String birthday;
            private String gender;
            private int coupons;
            private String customer_service_tel;
            private String common_user_center_notice;
            private int user_order_count;
            private int user_goods_favor_count;
            private int user_goods_browse_count;
            private int common_message_total;
            private int common_app_is_enable_answer;
            private List<UserOrderStatusBean> user_order_status;

            @Override
            public String toString() {
                return "InfoBean{" +
                        "integral=" + integral +
                        ", avatar='" + avatar + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", username='" + username + '\'' +
                        ", money='" + money + '\'' +
                        ", mobile='" + mobile + '\'' +
                        ", birthday='" + birthday + '\'' +
                        ", gender='" + gender + '\'' +
                        ", coupons=" + coupons +
                        ", customer_service_tel='" + customer_service_tel + '\'' +
                        ", common_user_center_notice='" + common_user_center_notice + '\'' +
                        ", user_order_count=" + user_order_count +
                        ", user_goods_favor_count=" + user_goods_favor_count +
                        ", user_goods_browse_count=" + user_goods_browse_count +
                        ", common_message_total=" + common_message_total +
                        ", common_app_is_enable_answer=" + common_app_is_enable_answer +
                        ", user_order_status=" + user_order_status +
                        '}';
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public int getCoupons() {
                return coupons;
            }

            public void setCoupons(int coupons) {
                this.coupons = coupons;
            }

            public String getCustomer_service_tel() {
                return customer_service_tel;
            }

            public void setCustomer_service_tel(String customer_service_tel) {
                this.customer_service_tel = customer_service_tel;
            }

            public String getCommon_user_center_notice() {
                return common_user_center_notice;
            }

            public void setCommon_user_center_notice(String common_user_center_notice) {
                this.common_user_center_notice = common_user_center_notice;
            }

            public int getUser_order_count() {
                return user_order_count;
            }

            public void setUser_order_count(int user_order_count) {
                this.user_order_count = user_order_count;
            }

            public int getUser_goods_favor_count() {
                return user_goods_favor_count;
            }

            public void setUser_goods_favor_count(int user_goods_favor_count) {
                this.user_goods_favor_count = user_goods_favor_count;
            }

            public int getUser_goods_browse_count() {
                return user_goods_browse_count;
            }

            public void setUser_goods_browse_count(int user_goods_browse_count) {
                this.user_goods_browse_count = user_goods_browse_count;
            }

            public int getCommon_message_total() {
                return common_message_total;
            }

            public void setCommon_message_total(int common_message_total) {
                this.common_message_total = common_message_total;
            }

            public int getCommon_app_is_enable_answer() {
                return common_app_is_enable_answer;
            }

            public void setCommon_app_is_enable_answer(int common_app_is_enable_answer) {
                this.common_app_is_enable_answer = common_app_is_enable_answer;
            }

            public List<UserOrderStatusBean> getUser_order_status() {
                return user_order_status;
            }

            public void setUser_order_status(List<UserOrderStatusBean> user_order_status) {
                this.user_order_status = user_order_status;
            }

            public static class UserOrderStatusBean {
                /**
                 * name : 待确认
                 * status : 0
                 * count : 0
                 */

                private String name;
                private int status;
                private int count;

                @Override
                public String toString() {
                    return "UserOrderStatusBean{" +
                            "name='" + name + '\'' +
                            ", status=" + status +
                            ", count=" + count +
                            '}';
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }
            }
        }
    }
}
