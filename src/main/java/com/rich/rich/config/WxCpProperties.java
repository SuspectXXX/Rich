package com.rich.rich.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "wechat.cp")
@Component
public class WxCpProperties {
    private String corpId;
    private List<AppConfig> addConfigs;

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public List<AppConfig> getAddConfigs() {
        return addConfigs;
    }

    public void setAddConfigs(List<AppConfig> addConfigs) {
        this.addConfigs = addConfigs;
    }

    public static class AppConfig {
        private int agentId;
        private String secret;
        private String token;
        private String aesKey;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAesKey() {
            return aesKey;
        }

        public void setAesKey(String aesKey) {
            this.aesKey = aesKey;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
