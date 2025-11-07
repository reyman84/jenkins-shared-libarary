def call () {
    node {
        mvn --version; 
        java -version
        jenkins --version
        git --version
        ansible --version
    }
}