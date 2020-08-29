package com.example.demo.model.enmu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author onealzhuyingjie
 * @date 20190423 上午10:41
 **/
@Getter
@AllArgsConstructor
public enum ManageOrderClauseEnum {
    assetScore("asset_score"),
    assetImpactFactor("asset_impact_factor"),
    storageScore("health_score"),
    impactFactor("impact_factor"),
    securityScore("security_score"),
    securityImpactFactor("security_impact_factor"),
    calculateScore("calculate_score")
    ;

    private String col;

    public static boolean isValidCode(String clause) {
        return Arrays.stream(ManageOrderClauseEnum.values()).anyMatch((type) -> type.name().equals(clause));
    }

    public static String getColByClause(String clause) {
        return Arrays.stream(ManageOrderClauseEnum.values()).filter((type) -> type.name().equals(clause)).map(ManageOrderClauseEnum::getCol).findAny().orElse(null);
    }
}
