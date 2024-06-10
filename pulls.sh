#!/bin/bash

# Diretórios dos seus projetos
PROJECT_DIRS=(
    "$HOME/Documents/cursoJava"
    "$HOME/Documents/app-finance"
    "$HOME/Documents/app-calculator"
    "$HOME/Documents/app-logger"
)

# Função para fazer os pulls
pull() {
    local dir="$1"
    cd "$dir" || exit
    git push origin master
}

# Iterar sobre os diretórios dos projetos e executar commit e push
for project_dir in "${PROJECT_DIRS[@]}"; do
    echo -e "\nProcessando $project_dir"
    pull "$project_dir"
done

echo -e "\n\nPulls completados!!!"