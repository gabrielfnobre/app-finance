#!/bin/bash

# Diretórios dos seus projetos
PROJECT_DIRS=(
    "$HOME/Documents/cursoJava"
    "$HOME/Documents/app-finance"
    "$HOME/Documents/app-calculator"
    "$HOME/Documents/app-logger"
)

# data atual!
CURRENT_DATE=$(date +%Y/%m/%d)
echo -e "Iniciando os commits e pushes\nCommits serão feitos para a seguinte data: $CURRENT_DATE"

# Mensagem de commit
COMMIT_MESSAGE="commit in $CURRENT_DATE"

# Função para fazer commit e push
commit_and_push() {
    local dir="$1"
    cd "$dir" || exit
    git add .
    git commit -a -m "$COMMIT_MESSAGE"
    git push origin master
}

# Iterar sobre os diretórios dos projetos e executar commit e push
for project_dir in "${PROJECT_DIRS[@]}"; do
    echo -e "\nProcessando $project_dir"
    commit_and_push "$project_dir"
done

echo -e "\n\nCommit e push completados para todos os repositórios."