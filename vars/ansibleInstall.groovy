def call() {
    node {
    sh """
        echo "Checking Ansible installation..."
        
        if command -v ansible >/dev/null 2>&1; then
            echo "Ansible is already installed."
        else
            echo "Installing Ansible..."
            sudo apt update -y
            sudo apt install software-properties-common -y
            sudo add-apt-repository --yes --update ppa:ansible/ansible
            sudo apt install ansible -y
        fi
        echo "Installed Ansible Version:"
        ansible --version
    """
    }
}