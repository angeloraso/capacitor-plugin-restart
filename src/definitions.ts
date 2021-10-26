export interface RestartPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
