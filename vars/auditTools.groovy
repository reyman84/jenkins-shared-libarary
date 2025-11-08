def call() {
    sh """
        mvn --version; 
        java -version
        jenkins --version
        git --version
        ansible --version
    """
}