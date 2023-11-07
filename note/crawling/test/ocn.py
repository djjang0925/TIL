import requests
from bs4 import BeautifulSoup

response = requests.get("https://ocn.cjenm.com/ko/ocn_movies-schedule/")
html = response.text

soup = BeautifulSoup(html, 'html.parser')
titles = soup.select('.txt')
sub_titles = soup.select('.sub_title')

for i in range(len(titles)):
    print(f'제목: {titles[i].text}')
    print(f'부제: {sub_titles[i].text}')
    print()