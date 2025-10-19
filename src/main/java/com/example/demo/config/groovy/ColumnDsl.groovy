import com.example.demo.config.groovy.BenchmarkQuestionStageColumn
import com.example.demo.config.groovy.ColumnConfig
public class ColumnDsl {
    private ColumnConfig config = new ColumnConfig()
    private String currentScenario
    private List<BenchmarkQuestionStageColumn> currentColumns = new ArrayList<>()

    def scenario(String scenarioName, Closure closure) {
        this.currentScenario = scenarioName
        closure.delegate = this
        closure.call()
        config.addScenario(currentScenario, currentColumns)
        currentColumns = new ArrayList<>()
    }

    def column(String columnName, Closure closure) {
        def columnBuilder = new ColumnBuilder(columnName)
        closure.delegate = columnBuilder
        closure.call()
        currentColumns.add(columnBuilder.build())
    }

    ColumnConfig getConfig() {
        return config
    }
}

public class ColumnBuilder {
    private BenchmarkQuestionStageColumn column

    ColumnBuilder(String columnName) {
        this.column = new BenchmarkQuestionStageColumn()
        this.column.setColumn(columnName)
    }

    def dataType(String dataType) {
        column.setDataType(dataType)
    }

    def displayName(String displayName) {
        column.setDisplayName(displayName)
    }

    def isDisplay(Integer isDisplay) {
        column.setIsDisplay(isDisplay)
    }

    def isDisplay(Boolean isDisplay) {
        column.setIsDisplay(isDisplay ? 1 : 0)
    }

    BenchmarkQuestionStageColumn build() {
        return column
    }
}