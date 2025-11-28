param([string]$release = '21')

Write-Output "Cleaning bin folder..."
Remove-Item -Recurse -Force .\bin\* -ErrorAction SilentlyContinue

Write-Output "Creating bin folder if needed..."
New-Item -ItemType Directory -Path .\bin -Force | Out-Null

Write-Output "Compiling sources with --release $release..."
$mod = Join-Path $PWD 'src\module-info.java'
$javaFiles = Get-ChildItem -Recurse -Path src -Filter *.java | Where-Object { $_.FullName -ne $mod } | ForEach-Object { $_.FullName }
javac --release $release -d bin $mod $javaFiles

Write-Output "Done. To run use: java --module-path bin -m AiFitnessCoach/fitcoach.app.Main"