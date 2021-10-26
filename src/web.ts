import { WebPlugin } from '@capacitor/core';

import type { RestartPlugin } from './definitions';

export class RestartWeb extends WebPlugin implements RestartPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
