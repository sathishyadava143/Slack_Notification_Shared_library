def call(String build_status = "STARTED") {
    build_status = build_status ?: "SUCCESS"

    def subject = "${build_status}, JOB_NAME: ${env.JOB_NAME}, BUILD_NUMBER: ${env.BUILD_NUMBER}, TO_VISIT: ${env.BUILD_URL}"
    def colorCode = (build_status == "SUCCESS") ? '#00FF00' : '#FF0000'

    slackSend(color: colorCode, message: subject)
}

