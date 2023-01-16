import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'term'
})
export class SearchPipe implements PipeTransform {

  transform(items: any[]|null, searchText: string|null): any[] {
    if (!items) {
      return [];
    }
    if (!searchText) {
      return items;
    }
    searchText = searchText.toLocaleLowerCase();

    return items.filter(it => {
      return it.title.toLocaleLowerCase().includes(searchText);
    });
  }
}
