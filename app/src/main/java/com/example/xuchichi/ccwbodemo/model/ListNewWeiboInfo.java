package com.example.xuchichi.ccwbodemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by xuchichi on 2017/7/13.
 * 获取当前登录用户及其所关注（授权）用户的最新微博
 */
public class ListNewWeiboInfo {

    /**
     * statuses : [{"created_at":"Thu Jul 13 11:26:40 +0800 2017","id":4129011002724711,"mid":"4129011002724711","idstr":"4129011002724711","text":"【\u201c梦想成真\u201d#朴明秀#爱妻韩秀敏加盟《Single Wife》】13日，SBS新综艺《妻子们的浪漫逃离-Single Wife》节目组表示：\u201c节目已经正式被编排了，朴明秀的妻子韩秀敏会出演。之前出演的四对夫妇都会出演。\u201d吸引了众人视线。《Single Wife》是这段时间为了育儿和家务受苦的妻子们，丈夫们给妻子特别假...全文： http://m.weibo.cn/1875436151/4129011002724711 \u200b","textLength":307,"source_allowclick":0,"source_type":1,"source":"<a href=\"http://app.weibo.com/t/feed/6vtZb0\" rel=\"nofollow\">微博 weibo.com<\/a>","favorited":false,"truncated":false,"in_reply_to_status_id":"","in_reply_to_user_id":"","in_reply_to_screen_name":"","pic_urls":[{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gyealcj20eh0wc773.jpg"}],"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg","bmiddle_pic":"http://wx1.sinaimg.cn/bmiddle/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg","original_pic":"http://wx1.sinaimg.cn/large/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg","geo":null,"user":{"id":1875436151,"idstr":"1875436151","class":1,"screen_name":"韩流台","name":"韩流台","province":"400","city":"18","location":"海外 韩国","description":"跟韩国同步【最快】的韩流资讯~【最热】的韩流话题~本微博只报道韩国新闻网站及报纸每日最新信息不包含博主个人意见~请尊重劳动成果","url":"http://koreaxing.com","profile_image_url":"http://tva1.sinaimg.cn/crop.0.0.180.180.50/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg","cover_image":"http://ww1.sinaimg.cn/crop.0.0.980.300/6fc8e277jw1dzgm3m4nkgj.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.0.0/6fc8e277jw1ey0bb6rj8cj20hs0hrdi5.jpg","profile_url":"kryibada","domain":"kryibada","weihao":"","gender":"f","followers_count":2057611,"friends_count":1860,"pagefriends_count":1,"statuses_count":39660,"favourites_count":87,"created_at":"Fri Nov 26 17:11:32 +0800 2010","following":true,"allow_all_act_msg":false,"geo_enabled":true,"verified":false,"verified_type":-1,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva1.sinaimg.cn/crop.0.0.180.180.180/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg","avatar_hd":"http://tva1.sinaimg.cn/crop.0.0.180.180.1024/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg","verified_reason":"","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","follow_me":false,"online_status":0,"bi_followers_count":1011,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":6,"block_word":0,"block_app":1,"credit_score":80,"user_ability":264,"urank":43,"story_read_state":-1},"reposts_count":0,"comments_count":0,"attitudes_count":0,"isLongText":true,"mlevel":0,"visible":{"type":0,"list_id":0},"biz_feature":0,"page_type":32,"hasActionTypeCard":0,"darwin_tags":[],"hot_weibo_tags":[],"text_tag_tips":[],"rid":"0_0_1_2676248865836794248","userType":0,"positive_recom_flag":0,"gif_ids":"","is_show_bulletin":2,"comment_manage_info":{"comment_permission_type":-1}}]
     * advertises : []
     * ad : []
     * hasvisible : false
     * previous_cursor : 0
     * next_cursor : 4129010982146747
     * total_number : 150
     * interval : 2000
     * uve_blank : -1
     * since_id : 4129011002724711
     * max_id : 4129010982146747
     * has_unread : 0
     */

    public boolean hasvisible;
    public int previous_cursor;
    public long next_cursor;
    public int total_number;
    public int interval;
    public int uve_blank;
    public long since_id;
    public long max_id;
    public int has_unread;
    public List<StatusesBean> statuses;
    public List<?> advertises;
    public List<?> ad;

    public static class StatusesBean {
        /**
         * created_at : Thu Jul 13 11:26:40 +0800 2017
         * id : 4129011002724711
         * mid : 4129011002724711
         * idstr : 4129011002724711
         * text : 【“梦想成真”#朴明秀#爱妻韩秀敏加盟《Single Wife》】13日，SBS新综艺《妻子们的浪漫逃离-Single Wife》节目组表示：“节目已经正式被编排了，朴明秀的妻子韩秀敏会出演。之前出演的四对夫妇都会出演。”吸引了众人视线。《Single Wife》是这段时间为了育儿和家务受苦的妻子们，丈夫们给妻子特别假...全文： http://m.weibo.cn/1875436151/4129011002724711 ​
         * textLength : 307
         * source_allowclick : 0
         * source_type : 1
         * source : <a href="http://app.weibo.com/t/feed/6vtZb0" rel="nofollow">微博 weibo.com</a>
         * favorited : false
         * truncated : false
         * in_reply_to_status_id :
         * in_reply_to_user_id :
         * in_reply_to_screen_name :
         * pic_urls : [{"thumbnail_pic":"http://wx1.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg"},{"thumbnail_pic":"http://wx4.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gyealcj20eh0wc773.jpg"}]
         * thumbnail_pic : http://wx1.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg
         * bmiddle_pic : http://wx1.sinaimg.cn/bmiddle/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg
         * original_pic : http://wx1.sinaimg.cn/large/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg
         * geo : null
         * user : {"id":1875436151,"idstr":"1875436151","class":1,"screen_name":"韩流台","name":"韩流台","province":"400","city":"18","location":"海外 韩国","description":"跟韩国同步【最快】的韩流资讯~【最热】的韩流话题~本微博只报道韩国新闻网站及报纸每日最新信息不包含博主个人意见~请尊重劳动成果","url":"http://koreaxing.com","profile_image_url":"http://tva1.sinaimg.cn/crop.0.0.180.180.50/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg","cover_image":"http://ww1.sinaimg.cn/crop.0.0.980.300/6fc8e277jw1dzgm3m4nkgj.jpg","cover_image_phone":"http://ww1.sinaimg.cn/crop.0.0.0.0/6fc8e277jw1ey0bb6rj8cj20hs0hrdi5.jpg","profile_url":"kryibada","domain":"kryibada","weihao":"","gender":"f","followers_count":2057611,"friends_count":1860,"pagefriends_count":1,"statuses_count":39660,"favourites_count":87,"created_at":"Fri Nov 26 17:11:32 +0800 2010","following":true,"allow_all_act_msg":false,"geo_enabled":true,"verified":false,"verified_type":-1,"remark":"","insecurity":{"sexual_content":false},"ptype":0,"allow_all_comment":true,"avatar_large":"http://tva1.sinaimg.cn/crop.0.0.180.180.180/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg","avatar_hd":"http://tva1.sinaimg.cn/crop.0.0.180.180.1024/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg","verified_reason":"","verified_trade":"","verified_reason_url":"","verified_source":"","verified_source_url":"","follow_me":false,"online_status":0,"bi_followers_count":1011,"lang":"zh-cn","star":0,"mbtype":12,"mbrank":6,"block_word":0,"block_app":1,"credit_score":80,"user_ability":264,"urank":43,"story_read_state":-1}
         * reposts_count : 0
         * comments_count : 0
         * attitudes_count : 0
         * isLongText : true
         * mlevel : 0
         * visible : {"type":0,"list_id":0}
         * biz_feature : 0
         * page_type : 32
         * hasActionTypeCard : 0
         * darwin_tags : []
         * hot_weibo_tags : []
         * text_tag_tips : []
         * rid : 0_0_1_2676248865836794248
         * userType : 0
         * positive_recom_flag : 0
         * gif_ids :
         * is_show_bulletin : 2
         * comment_manage_info : {"comment_permission_type":-1}
         */

        public String created_at;
        public long id;//	微博ID
        public String mid;//	微博MID
        public String idstr;//	字符串型的微博ID
        public String text;//微博信息内容
        public int textLength;
        public int source_allowclick;
        public int source_type;
        public String source;//	微博来源
        public boolean favorited;//是否已收藏，true：是，false：否
        public boolean truncated;//是否被截断，true：是，false：否
        public String in_reply_to_status_id;//回复ID
        public String in_reply_to_user_id;//回复人UID
        public String in_reply_to_screen_name;//回复人昵称
        public String thumbnfavoritedail_pic;//	中等尺寸图片地址，没有时不返回此字段
        public String bmiddle_pic;//	中等尺寸图片地址，没有时不返回此字段
        public String original_pic;//原始图片地址，没有时不返回此字段
        public Object geo;//地理信息字段
        public UserBean user;//微博作者的用户信息字段
        public int reposts_count;//	转发数
        public int comments_count;//	评论数
        public int attitudes_count;//	表态数
        public boolean isLongText;
        public int mlevel;
        public VisibleBean visible;
        public int biz_feature;
        public int page_type;
        public int hasActionTypeCard;
        public String rid;
        public int userType;
        public int positive_recom_flag;
        public String gif_ids;
        public int is_show_bulletin;
        public CommentManageInfoBean comment_manage_info;
        public List<PicUrlsBean> pic_urls;
        public List<?> darwin_tags;
        public List<?> hot_weibo_tags;
        public List<?> text_tag_tips;

        public static class UserBean {
            /**
             * id : 1875436151
             * idstr : 1875436151
             * class : 1
             * screen_name : 韩流台
             * name : 韩流台
             * province : 400
             * city : 18
             * location : 海外 韩国
             * description : 跟韩国同步【最快】的韩流资讯~【最热】的韩流话题~本微博只报道韩国新闻网站及报纸每日最新信息不包含博主个人意见~请尊重劳动成果
             * url : http://koreaxing.com
             * profile_image_url : http://tva1.sinaimg.cn/crop.0.0.180.180.50/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg
             * cover_image : http://ww1.sinaimg.cn/crop.0.0.980.300/6fc8e277jw1dzgm3m4nkgj.jpg
             * cover_image_phone : http://ww1.sinaimg.cn/crop.0.0.0.0/6fc8e277jw1ey0bb6rj8cj20hs0hrdi5.jpg
             * profile_url : kryibada
             * domain : kryibada
             * weihao :
             * gender : f
             * followers_count : 2057611
             * friends_count : 1860
             * pagefriends_count : 1
             * statuses_count : 39660
             * favourites_count : 87
             * created_at : Fri Nov 26 17:11:32 +0800 2010
             * following : true
             * allow_all_act_msg : false
             * geo_enabled : true
             * verified : false
             * verified_type : -1
             * remark :
             * insecurity : {"sexual_content":false}
             * ptype : 0
             * allow_all_comment : true
             * avatar_large : http://tva1.sinaimg.cn/crop.0.0.180.180.180/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg
             * avatar_hd : http://tva1.sinaimg.cn/crop.0.0.180.180.1024/6fc8e277jw1e8qgp5bmzyj2050050aa8.jpg
             * verified_reason :
             * verified_trade :
             * verified_reason_url :
             * verified_source :
             * verified_source_url :
             * follow_me : false
             * online_status : 0
             * bi_followers_count : 1011
             * lang : zh-cn
             * star : 0
             * mbtype : 12
             * mbrank : 6
             * block_word : 0
             * block_app : 1
             * credit_score : 80
             * user_ability : 264
             * urank : 43
             * story_read_state : -1
             */

            public int id;
            public String idstr;
            @SerializedName("class")
            public int classX;
            public String screen_name;
            public String name;
            public String province;
            public String city;
            public String location;
            public String description;
            public String url;
            public String profile_image_url;
            public String cover_image;
            public String cover_image_phone;
            public String profile_url;
            public String domain;
            public String weihao;
            public String gender;
            public int followers_count;
            public int friends_count;
            public int pagefriends_count;
            public int statuses_count;
            public int favourites_count;
            public String created_at;
            public boolean following;
            public boolean allow_all_act_msg;
            public boolean geo_enabled;
            public boolean verified;
            public int verified_type;
            public String remark;
            public InsecurityBean insecurity;
            public int ptype;
            public boolean allow_all_comment;
            public String avatar_large;
            public String avatar_hd;
            public String verified_reason;
            public String verified_trade;
            public String verified_reason_url;
            public String verified_source;
            public String verified_source_url;
            public boolean follow_me;
            public int online_status;
            public int bi_followers_count;
            public String lang;
            public int star;
            public int mbtype;
            public int mbrank;
            public int block_word;
            public int block_app;
            public int credit_score;
            public int user_ability;
            public int urank;
            public int story_read_state;

            public static class InsecurityBean {
                /**
                 * sexual_content : false
                 */

                public boolean sexual_content;
            }
        }

        public static class VisibleBean {
            /**
             * type : 0
             * list_id : 0
             */

            public int type;
            public int list_id;
        }

        public static class CommentManageInfoBean {
            /**
             * comment_permission_type : -1
             */

            public int comment_permission_type;
        }

        public static class PicUrlsBean {
            /**
             * thumbnail_pic : http://wx1.sinaimg.cn/thumbnail/6fc8e277ly1fhi3gxsthgj20ep0f2dgr.jpg
             */

            public String thumbnail_pic;//缩略图片地址，没有时不返回此字段
        }
    }
}
