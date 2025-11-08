def call() {
    sh '''
        echo "Checking OS..."

        OS=$(grep "^ID=" /etc/os-release | cut -d= -f2 | tr -d '"')

        echo "Detected OS: $OS"
        echo "Installing Ansible..."

        if command -v ansible >/dev/null 2>&1; then
            echo "Ansible already installed."
            exit 0
        fi

        if [ "$OS" = "ubuntu" ] || [ "$OS" = "debian" ]; then
            sudo apt update -y
            sudo apt install -y ansible

        elif [ "$OS" = "amzn" ] || [ "$OS" = "rhel" ] || [ "$OS" = "centos" ]; then
            sudo yum install -y ansible || sudo dnf install -y ansible

        else
            echo "Unsupported OS: $OS"
            exit 1
        fi

        echo "Installed Ansible Version:"
        ansible --version
    '''
}
