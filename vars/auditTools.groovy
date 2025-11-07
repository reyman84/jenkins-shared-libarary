def call() {
    node {
        sh """
            mvn --version; 
            java -version
            jenkins --version
            git --version
            ansible --version
        """
    }
}