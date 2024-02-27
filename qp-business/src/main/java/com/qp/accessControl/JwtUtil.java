package com.qp.accessControl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * token工具类
 * 设置15分钟过期
 * 私钥是heqiuyu的md5加密，加上lrd（lrd隐藏在字段中）
 * */
public class JwtUtil {
    /*过期时间 15分钟 */
    private static final long EXPIRE_TIME = 15*60*1000;
    /*token私钥*/
    private static final String TOKEN_SECRET = "LA1BE2423754C1BR97709CA99546E73DD74";
    /**
     * 生成token签名
     * @param userId 用户id
     * @return 加密之后的token，异常返回null
     * */
    public static String sign(String userId){
        try {
            //设置过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            //设置私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","HS256");
            /**
             * 设置附带信息
             * 1 头部信息
             * 2 用户信息
             * 3 时间
             * 4 加密算法*/
            return JWT.create()
                    .withHeader(header)
                    .withClaim("userId",userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            return null;
        }
    }
    /**
     * 验证token是否符合规则
     * @param token token信息
     * @return 正确返回true，错误返回false
     * */
    public static boolean verify(String token){
        try {
            //加密方式
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //生成jwt规则
            JWTVerifier verifier = JWT.require(algorithm).build();
            //验证token是否符合规则
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /**
     * 从token中获取info信息
     * @param token token信息
     * @param info 需要获取的信息：用户名，密码，用户id
     * @return 需要的信息
     */
    public static String getUserInfo(String token,String info){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(info).asString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}