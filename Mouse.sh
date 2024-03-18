Clear-Host
Echo "keep-alive with Scroll Lock..."
$WShell = New-Object -com "Wscript.Shell"

while($true)
{
  $Wshell.sendkeys("{SCROLLLOCK}")
  Start-Sleep -Millisecond 10
  $Wshell.sendkeys("{SCROLLLOCK}") 
  Start-Sleep -Second 120
}