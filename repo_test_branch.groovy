pipeline {
  agent any
  environment { 
        example key = 'example value'
    }
  parameters{
      choice(choices: 'Dev\nTest\nProd',description:'Development',name:'branch')
      
  }
    stages {
      stage("git") {
            steps {
                
                echo "choiceExample: ${params.choiceExample}"
               
            }
        }
        stage("laa"){
            environment { 
                Secret_key = credentials('secret') 
            }
        }
        stage ("Clone from Git Repo") {
            steps {
                scripts {
                    
                    git branch: "${branch}", credentialsId: '327dfd62-48fa-459e-95fb-875ea8c12126', url: 'git@github.com:aswathipcg/DemoAppJenkin.git'
                }
            }
        }
       
      }
  
}
