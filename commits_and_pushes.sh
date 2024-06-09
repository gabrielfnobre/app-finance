#!/bin/bash

#caminho do computador atual
COMPUTER_NAME=$(hostname)

# Diretórios dos seus projetos
PROJECT_DIRS=(
    "$HOME/Documents/cursoJava"
    "$HOME/Documents/app-finance"
    "$HOME/Documents/app-calculator"
    "$HOME/Documents/app-logger"
)

# data atual!
CURRENT_DATE=$(%Y-%m-%d)

# Mensagem de commit
COMMIT_MESSAGE="commit in $CURRENT_DATE"

# Função para fazer commit e push
commit_and_push() {
    local dir="$1"
    cd "$dir" || exit
    git add .
    git commit -m "$COMMIT_MESSAGE"
    git push
}

# Iterar sobre os diretórios dos projetos e executar commit e push
for project_dir in "${PROJECT_DIRS[@]}"; do
    echo "Processando $project_dir"
    commit_and_push "$project_dir"
done

echo "Commit e push completados para todos os repositórios."