scenario("CHATBI_knowledge_retrieval") {
    column("businessType") {
        dataType "string"
        displayName "业务类型"
        isDisplay false
    }

    column("domainId") {
        dataType "int"
        displayName "业务域ID"
        isDisplay false
    }

    column("domainName") {
        dataType "string"
        displayName "业务域名称"
        isDisplay true
    }

    column("retrievalStrategy") {
        dataType "string"
        displayName "检索策略"
        isDisplay true
    }

    column("similarityThreshold") {
        dataType "double"
        displayName "相似度阈值"
        isDisplay true
    }

    column("textSimilarityWeight") {
        dataType "double"
        displayName "文本相似度权重"
        isDisplay true
    }

    column("topN") {
        dataType "int"
        displayName "topN"
        isDisplay true
    }

    column("businessCustomSize") {
        dataType "int"
        displayName "业务习惯条数"
        isDisplay true
    }
}

// 可以定义多个业务场景
scenario("CHATBI_data_analysis") {
    column("analysisType") {
        dataType "string"
        displayName "分析类型"
        isDisplay true
    }

    column("queryTime") {
        dataType "string"
        displayName "查询时间"
        isDisplay true
    }
}